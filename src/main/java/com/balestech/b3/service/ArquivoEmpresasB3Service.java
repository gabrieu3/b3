package com.balestech.b3.service;

import com.balestech.b3.dto.EmpresasB3;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ArquivoEmpresasB3Service {

    @Autowired
    EmpresasB3Service empresasB3Service;

    public void createFile() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        Writer writer = new FileWriter("EmpresasB3" + formatNow() + ".csv");
        List<EmpresasB3> empresasB3List = empresasB3Service.getAllEmpresas();
        gravaNoArquivoUsandoOpenCSV(writer, empresasB3List);
        writer.close();
    }

    public void gravaNoArquivoUsandoOpenCSV(Writer writer, List<EmpresasB3> empresasB3List) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        new StatefulBeanToCsvBuilder<EmpresasB3>(writer)
                .withSeparator(';')
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withEscapechar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
                .withLineEnd(CSVWriter.DEFAULT_LINE_END)
                .build().write(empresasB3List);
    }

    private String formatNow(){
        return new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date());
    }
}
