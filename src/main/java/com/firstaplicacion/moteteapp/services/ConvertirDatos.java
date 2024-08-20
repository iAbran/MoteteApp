//package com.firstaplicacion.moteteapp.services;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class ConvertirDatos implements IConvertirDatos {
//    private ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public <T> T obtenerDatos(String json, Class<T> tClass) {
//        try {
//            return objectMapper.readValue(json,tClass);
//        }catch (JsonProcessingException e){
//            throw new RuntimeException(e);
//        }
//    }
//}
