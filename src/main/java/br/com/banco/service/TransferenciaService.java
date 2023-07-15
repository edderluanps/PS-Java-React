package br.com.banco.service;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public List<Transferencia> getListaTransferencias(){
        return transferenciaRepository.findAll();
    }

    public Transferencia getTransferenciaById(int id){
        return transferenciaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Transferencia não encontrada", TransferenciaService.class.getName()));
    }

    public Transferencia novaTransferencia(Transferencia transferencia){
        return transferenciaRepository.save(transferencia);
    }

}
