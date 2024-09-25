package com.example.demo.Service;

import com.example.demo.DTO.RueditasRequestDTO;

import java.io.IOException;

public interface RueditasService {
    String[] buscarRueditas(RueditasRequestDTO rueditasRequestDTO)throws IOException;
}
