package com.example.demo.Service.impl;


import com.example.demo.DTO.RueditasRequestDTO;
import com.example.demo.Service.RueditasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class RueditasServiceImpl implements RueditasService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] buscarRueditas(RueditasRequestDTO rueditasRequestDTO) throws IOException {

        String[] rueditas = null;
        Resource resource = resourceLoader.getResource("classpath:rueditas.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] dates = line.split(";");
                if (rueditasRequestDTO.placa().equals(dates[1])){
                    rueditas = new String[5];
                    rueditas[0] = dates[2];
                    rueditas[1] = dates[3];
                    rueditas[2] = dates[4];
                    rueditas[3] = dates[5];
                    rueditas[4] = dates[6];
                    break;
                }
            }

        } catch (Exception e) {
            rueditas = null;
            throw new IOException(e);
        }

        return rueditas;
    }
}
