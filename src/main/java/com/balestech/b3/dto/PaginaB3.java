package com.balestech.b3.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PaginaB3 implements Serializable {
    @JsonProperty("pageNumber")
    private String pageNumber;
    @JsonProperty("pageSize")
    private Integer pageSize;
    @JsonProperty("totalRecords")
    private String totalRecords;
    @JsonProperty("totalPages")
    private Integer totalPages;
}
