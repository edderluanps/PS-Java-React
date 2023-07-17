package br.com.banco.service;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public List<Transferencia> getListaTransferencias(){
        return transferenciaRepository.findAll();
    }

    public Transferencia getTransferenciaById(int id){
        return transferenciaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transferencia não encontrada!"));
    }

    public Transferencia novaTransferencia(Transferencia transferencia){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        transferencia.setData_transferencia(timestamp);
        return transferenciaRepository.save(transferencia);
    }

    public List<Transferencia> filtrarTransferencia(String nomeOperador, Date dataInicio, Date dataFim){
        return transferenciaRepository.filtrarTransferencias(nomeOperador, dataInicio, dataFim);
    }

}
