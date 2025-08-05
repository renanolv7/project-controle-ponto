package com.estudos.api_controle_ponto.services;

import com.estudos.api_controle_ponto.exceptions.RegistroJaRealizadoException;
import com.estudos.api_controle_ponto.models.ControlePontoEntity;
import com.estudos.api_controle_ponto.repositories.ControlePontoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
@Service
public class ControlePontoService {
    private final ControlePontoRepository controlePontoRepository;
    public ControlePontoService(ControlePontoRepository controlePontoRepository) {
        this.controlePontoRepository = controlePontoRepository;
    }

    public ControlePontoEntity registrarPonto(String matricula, LocalTime hora, LocalDate data) {

        Optional<ControlePontoEntity> registroExistente = controlePontoRepository.findByMatriculaAndDataAtual(matricula, data);

        if(registroExistente.isEmpty()){
            return registrarPrimeiraBatida(matricula, hora, data);
        } else {
            ControlePontoEntity registro = registroExistente.get();
            return registrarProximaBatida(registro, hora);
        }
    }
    private ControlePontoEntity registrarPrimeiraBatida(String matricula, LocalTime hora, LocalDate data) {
        ControlePontoEntity registro = new ControlePontoEntity();
        registro.setMatricula(matricula);
        registro.setHoraEntrada(hora);
        registro.setDataAtual(data);

        return controlePontoRepository.save(registro);
    }
    private ControlePontoEntity registrarProximaBatida(ControlePontoEntity registro, LocalTime hora) {
        if(registro.getHoraAlmoco() == null){
            registro.setHoraAlmoco(hora);
        } else if (registro.getHoraVoltaAlmoco() == null){
            registro.setHoraVoltaAlmoco(hora);
        } else if (registro.getHoraSaida() == null) {
            registro.setHoraSaida(hora);
        } else {
            throw new RegistroJaRealizadoException("Todos os pontos já foram batidos");
        }
        return controlePontoRepository.save(registro);
    }

}
