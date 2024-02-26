package br.com.lucasts.fipemotorcycles.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiModels (@JsonAlias("modelos") List<ApiDatas> apiModels){
}
