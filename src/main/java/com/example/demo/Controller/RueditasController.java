package com.example.demo.Controller;

import com.example.demo.DTO.RueditasRequestDTO;
import com.example.demo.DTO.RueditasResponseDTO;
import com.example.demo.Service.RueditasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rueditas")
public class RueditasController {

    @Autowired
    RueditasService rueditasService;

    @PostMapping("/search")
    public RueditasResponseDTO search(@RequestBody RueditasRequestDTO rueditasRequestDTO) {
        try {
            String[] dates = rueditasService.buscarRueditas(rueditasRequestDTO);
             if (dates == null) {
                     return new RueditasResponseDTO("01","Error: Car not found","","","","","");
             }
            return new RueditasResponseDTO("00","",dates[0],dates[1],dates[2],dates[3],dates[4]);

        } catch (Exception e) {
            return new RueditasResponseDTO("99","Error: A problem occurred","","","","","");
        }

    }
}
