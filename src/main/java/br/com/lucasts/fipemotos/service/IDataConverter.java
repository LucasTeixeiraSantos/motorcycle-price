package br.com.lucasts.fipemotos.service;

import java.util.List;

public interface IDataConverter {
    <T> T getData(String json, Class<T> genericClass);

    <T> List<T> getList(String json, Class<T> genericClass);
}
