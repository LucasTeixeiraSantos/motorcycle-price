package br.com.lucasts.fipemotorcycles.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiVehicle(
       @JsonAlias("Valor") String price,
       @JsonAlias("Marca") String brand,
       @JsonAlias("Modelo") String model,
       @JsonAlias("AnoModelo") Integer year,
       @JsonAlias("Combustivel") String fuelType
) {
}
