package br.com.lucasts.fipemotos.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiDatas(@JsonAlias("codigo") String code,
                       @JsonAlias("nome") String name){
}
