package com.example.excaption;

import lombok.Getter;

@Getter
public enum MessageTYPE {
    No_Record_Exist("1001","kayıt bulunamadı"),
    GENERAL_EXCAPTİON("9999","genel bir hata oluştu");


    private String code;
    private String message;

    MessageTYPE(String code, String message) {
        this.code = code;
        this.message = message;

    }


}
