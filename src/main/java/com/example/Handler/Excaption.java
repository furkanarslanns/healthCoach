package com.example.Handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Excaption<E> {

    private String hostName;
    private String path;
    private Date createTime;
    private E message;



}
