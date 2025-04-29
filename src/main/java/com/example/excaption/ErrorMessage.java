package com.example.excaption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

private MessageTYPE messageTYPE;
private String ofStatic;

    public String prepareErrorMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(messageTYPE.getMessage()) ;
        if (ofStatic != null) {
            stringBuilder.append(" : " +ofStatic);
        }
        return stringBuilder.toString();
    }
}
