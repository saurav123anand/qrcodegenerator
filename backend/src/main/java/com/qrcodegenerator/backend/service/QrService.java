package com.qrcodegenerator.backend.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;


@Service
@Slf4j
public class QrService {

    public byte[] generateQrCode(String text,int width,int height){
         /*MultiFormatWriter. This class is responsible for encoding data into a BitMatrix, which is a
             two-dimensional matrix of bits representing the QR code.*/
        try{
            MultiFormatWriter multiFormatWriter=new MultiFormatWriter();
            BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix,"PNG",byteArrayOutputStream);
            log.info("getting the response...");
            return byteArrayOutputStream.toByteArray();
        }
        catch (Exception e){
            e.printStackTrace();
            log.error("some error occurred");
            return null;
        }
        
    }

}
