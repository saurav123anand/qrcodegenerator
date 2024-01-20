package com.qrcodegenerator.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QrCode {
    private String text;
    private Integer height;
    private Integer width;
}
