package com.balestech.b3.service;

import com.balestech.b3.dto.EmpresasB3;
import com.balestech.b3.dto.PaginaEmpresasB3;
import com.balestech.b3.integration.FeignIntegrationB3;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class EmpresasB3Service {

    private static final Integer PRIMEIRA_PAGINA = 1;
    @Autowired
    FeignIntegrationB3 feignIntegrationB3;

    public PaginaEmpresasB3 getEmpresas(Integer pageNumber) throws JsonProcessingException {
       String pageParams = "{\"language\":\"pt-br\",\"pageNumber\":"+pageNumber+",\"pageSize\":120}";
       String pageBase64 = Base64.getEncoder().encodeToString(pageParams.getBytes());
       String paginaEmpresasB3 = feignIntegrationB3.getEmpresasB3(pageBase64);
       return new ObjectMapper().readValue(paginaEmpresasB3, PaginaEmpresasB3.class);

    }

    public List<EmpresasB3> getAllEmpresas() throws JsonProcessingException {
        List<EmpresasB3> empresasB3List = new ArrayList<>();
        PaginaEmpresasB3 paginaEmpresasB3 = getEmpresas(PRIMEIRA_PAGINA);
        empresasB3List.addAll(paginaEmpresasB3.getResults());
        for(int i = 2; i <= paginaEmpresasB3.getPage().getTotalPages(); i++){
            paginaEmpresasB3 = getEmpresas(i);
            System.out.println(i);
            empresasB3List.addAll(paginaEmpresasB3.getResults());
        }
        return empresasB3List;
    }
}
