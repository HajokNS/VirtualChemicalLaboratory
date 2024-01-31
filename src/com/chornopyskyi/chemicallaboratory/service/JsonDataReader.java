package com.chornopyskyi.chemicallaboratory.service;

import com.chornopyskyi.chemicallaboratory.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonDataReader {
    public JsonDataReader() {
    }


    //////зробити повернення List
    public static <T> T modelDataJsonReader(String pathToJson, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(new File(pathToJson), clazz);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}

