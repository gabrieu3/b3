package com.balestech.b3.controller;

import com.balestech.b3.dto.EmpresasB3;
import com.balestech.b3.dto.PaginaEmpresasB3;
import com.balestech.b3.service.ArquivoEmpresasB3Service;
import com.balestech.b3.service.EmpresasB3Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/empresas")
public class EmpresasListadasB3Controller {

    @Autowired
    EmpresasB3Service empresasB3Service;

    @Autowired
    ArquivoEmpresasB3Service arquivoEmpresasB3Service;

    @GetMapping(value = "{page}")
    public PaginaEmpresasB3 list(@PathVariable(value = "page") Integer page) throws JsonProcessingException {
        return empresasB3Service.getEmpresas(page);
    }

    @GetMapping
    public List<EmpresasB3> listAll() throws JsonProcessingException {
        return empresasB3Service.getAllEmpresas();
    }

    @GetMapping(value = "file")
    public void file() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        arquivoEmpresasB3Service.createFile();
    }

}
