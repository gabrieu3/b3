package com.balestech.b3.integration;

import com.balestech.b3.dto.PaginaEmpresasB3;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "b3", url = "https://sistemaswebb3-listados.b3.com.br/listedCompaniesProxy/CompanyCall/GetInitialCompanies/")
public interface FeignIntegrationB3 {


    @RequestMapping(method = RequestMethod.GET, value = "/{page}", produces = "application/json")
    String getEmpresasB3(@PathVariable("page") String page);
}