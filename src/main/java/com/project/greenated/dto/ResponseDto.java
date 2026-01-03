package com.project.greenated.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

    private boolean hasError;
    private int errorCode;
    private String message;
    private Object response;

}