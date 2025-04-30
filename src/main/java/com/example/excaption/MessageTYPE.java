package com.example.excaption;

import lombok.Getter;

@Getter
public enum MessageTYPE {
    No_Record_Exist("1001","Kayıt bulunamadı!"),
    GENERAL_EXCAPTİON("9999","Genel bir hata oluştu!"),
    No_Food("1002","Bu besin bulunamadı!");



    private String code;
    private String message;

    MessageTYPE(String code, String message) {
        this.code = code;
        this.message = message;

    }


}
