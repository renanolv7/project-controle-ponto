package com.estudos.api_controle_ponto.controllers;

import com.estudos.api_controle_ponto.services.ControlePontoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("controle")
public class ControlePontoControllers {
    private ControlePontoService controlePontoService;
    public ControlePontoControllers(ControlePontoService controlePontoService) {
        this.controlePontoService = controlePontoService;
    }
    static class PontoRequest {
        public String matricula;
        public LocalDate data;
        public LocalTime hora;
    }

    @PostMapping("/bater-ponto")
    public ResponseEntity<String> baterPonto(@RequestBody PontoRequest request){
        String infos = controlePontoService.registrarPonto(request.matricula, request.hora, request.data);
        return ResponseEntity.ok(infos);
    }
}
