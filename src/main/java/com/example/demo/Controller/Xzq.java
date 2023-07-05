package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
@RestController
@RequestMapping("/test1")
public class Xzq {

    private HttpsURLConnection httpsURLConnection;
    private InputStream inputStream;
    private OutputStream outputStream;
    private String url1;
    private String FileName;

    Xzq (){

    }
    @GetMapping("/removebook")
    public void TestDown(String url1,String FileName) {
        this.url1 = url1;
        this.FileName = FileName;
        URL url = null;
        try {
            url = new URL(this.url1);
            httpsURLConnection = (HttpsURLConnection) url.openConnection();
            inputStream = httpsURLConnection.getInputStream();
            outputStream = new FileOutputStream(this.FileName);
            int zj;
            byte[] b = new byte[1024];
            while ((zj = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, zj);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
                httpsURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }}
