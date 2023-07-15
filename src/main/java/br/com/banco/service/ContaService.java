package br.com.banco.service;

import br.com.banco.model.Conta;
import br.com.banco.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> getListaContas(){
        return contaRepository.findAll();
    }

    public Conta getContaById(int id){
        return contaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada!"));
    }

    public Conta salvarConta(Conta conta){
        return contaRepository.save(conta);
    }

    public void atualizarConta(int id_conta, Conta conta){
        contaRepository.findById(id_conta).map(obj ->{
            conta.setId_conta(obj.getId_conta());
            return contaRepository.save(conta);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada!"));
    }

    public void deletarConta(int id_conta){
        Conta contaObj = getContaById(id_conta);
        if (contaObj == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada!");
        }else {
            contaRepository.deleteById(id_conta);
        }
    }

}
