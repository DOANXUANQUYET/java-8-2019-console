package com.laptrinhjavaweb.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
    private String value;

    public HttpUtil(String value) {
        this.value = value;
    }

    public <T> T toModel(Class<T> tclass) {
        try {
            //mapper string thanh field object class (truyen gia tri, kieu object)
            return new ObjectMapper().readValue(value, tclass);
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        return null;
    }


    //ham nay chuyen jison thanh string
    public static HttpUtil of(BufferedReader reader) {
        StringBuilder jison = new StringBuilder();
        // tao chuoi ket qua tra ve
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                jison.append(line);
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }

        return new HttpUtil(jison.toString());
    }
}
