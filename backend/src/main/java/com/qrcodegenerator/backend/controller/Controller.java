package com.qrcodegenerator.backend.controller;

import com.qrcodegenerator.backend.model.QrCode;
import com.qrcodegenerator.backend.service.QrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class Controller {
    @Autowired
    private QrService qrService;

    @PostMapping(value = "/generateqr",produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateQR(@RequestBody QrCode qrCode){
        try{
            int width= qrCode.getWidth()!=null ? qrCode.getWidth() : 300;
            int height=qrCode.getHeight()!=null ? qrCode.getHeight() :300;
            byte[] bytes = qrService.generateQrCode(qrCode.getText(), width, height);
            return new ResponseEntity<>(bytes, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
