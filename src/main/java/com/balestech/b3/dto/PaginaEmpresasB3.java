package com.balestech.b3.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PaginaEmpresasB3 implements Serializable {
    @JsonProperty("page")
    PaginaB3 page;
    @JsonProperty("results")
    List<EmpresasB3> results;
}
