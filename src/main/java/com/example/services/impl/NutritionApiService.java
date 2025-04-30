package com.example.services.impl;

import com.example.dto.FoodDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@Service
public class NutritionApiService {
    private final RestTemplate restTemplate;
    private final String clientId;
    private final String clientSecret;
    private final String tokenUrl;
    private final String apiUrl;

    private String accessToken;
    private long tokenExpireTime;

    public NutritionApiService(
            @Value("${fatsecret.api.client-id}") String clientId,
            @Value("${fatsecret.api.client-secret}") String clientSecret,
            @Value("${fatsecret.api.token-url}") String tokenUrl,
            @Value("${fatsecret.api.api-url}") String apiUrl
    ) {
        this.restTemplate = new RestTemplate();
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.tokenUrl = tokenUrl;
        this.apiUrl = apiUrl;
    }

    private void authenticate() {
        if (accessToken == null || System.currentTimeMillis() >= tokenExpireTime) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.add("Authorization", "Basic " + getBasicAuthHeader());

            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            body.add("grant_type", "client_credentials");
            body.add("scope", "basic");

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

            ResponseEntity<Map> response = restTemplate.exchange(
                    tokenUrl,
                    HttpMethod.POST,
                    request,
                    Map.class
            );

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                accessToken = (String) response.getBody().get("access_token");
                Integer expiresIn = (Integer) response.getBody().get("expires_in");
                tokenExpireTime = System.currentTimeMillis() + expiresIn * 1000;
            }
        }
    }

    private String getBasicAuthHeader() {
        String auth = clientId + ":" + clientSecret;
        return Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
    }
//------------------------------------------------------------------------------------------
    public List<FoodDTO> searchFood(String foodName) {
        authenticate();

        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("method", "foods.search")
                .queryParam("search_expression", foodName)
                .queryParam("format", "json")
                .build()
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );

        List<FoodDTO> foods = new ArrayList<>();

        try {

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());

            JsonNode foodsNode = root.path("foods").path("food");

            if (foodsNode.isArray()) {
                for (JsonNode foodNode : foodsNode) {
                    String description = foodNode.path("food_description").asText().toLowerCase();

                    String name = foodNode.path("food_name").asText();
                    Double calories = description.contains("kcal") ? extractCalories(description) : null;
                    Double fat = description.contains("fat") ? extractFat(description) : null;
                    Double protein = description.contains("protein") ? extractProtein(description) : null;
                    Double carbs = description.contains("carbs") ? extractCarbs(description) : null;

                    foods.add(new FoodDTO(name, calories, protein, fat, carbs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return foods;
    }
//---------------------------------------------------------------
    private Double extractCalories(String description) {
        return extractValue(description, "calories");
    }
//--------------------------------------------------------------
    private Double extractFat(String description) {
        return extractValue(description, "Fat");
    }
//----------------------------------------------------------------
    private Double extractProtein(String description) {
        return extractValue(description, "Protein");
    }
//------------------------------------------------------------
    private Double extractCarbs(String description) {
        return extractValue(description, "Carbs");
    }

    private Double extractValue(String description, String key) {
        try {
            // normalize her şey küçük harf
            description = description.toLowerCase();
            key = key.toLowerCase();

            // parçalara ayır
            String[] parts = description.split("\\|");

            for (String part : parts) {
                part = part.trim();
                if (part.contains(key)) {
                    // örnek: calories: 89kcal
                    String[] split = part.split(":");
                    if (split.length == 2) {
                        String value = split[1]
                                .replace("kcal", "")
                                .replace("g", "")
                                .replaceAll("[^0-9.]", "") // sadece sayı ve . kalsın
                                .trim();
                        return Double.parseDouble(value);

                    }
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }



}

