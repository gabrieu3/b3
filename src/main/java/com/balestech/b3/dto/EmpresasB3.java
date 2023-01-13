package com.balestech.b3.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EmpresasB3 implements Serializable {
    @JsonProperty("codeCVM")
    private String codeCVM;
    @JsonProperty("issuingCompany")
    private String issuingCompany;
    @JsonProperty("companyName")
    private String companyName;
    @JsonProperty("tradingName")
    private String tradingName;
    @JsonProperty("cnpj")
    private String cnpj;
    @JsonProperty("marketIndicator")
    private String marketIndicator;
    @JsonProperty("typeBDR")
    private String typeBDR;
    @JsonProperty("dateListing")
    private String dateListing;
    @JsonProperty("status")
    private String status;
    @JsonProperty("segment")
    private String segment;
    @JsonProperty("segmentEng")
    private String segmentEng;
    @JsonProperty("type")
    private String type;
    @JsonProperty("market")
    private String market;

}
