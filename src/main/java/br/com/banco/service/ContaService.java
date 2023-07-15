package br.com.banco.service;

import br.com.banco.model.Conta;
import br.com.banco.repository.ContaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> getListaContas(){
        return contaRepository.findAll();
    }

    public Conta getContaById(int id){
        return contaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Conta não encontrada", ContaService.class.getName()));
    }

    public Conta salvarConta(Conta conta){
        return contaRepository.save(conta);
    }

    public void atualizarConta(int id, Conta conta){
        contaRepository.findById(id).map(obj ->{
            conta.setId_conta(obj.getId_conta());
            return contaRepository.save(conta);
        }).orElseThrow(() -> new ObjectNotFoundException("Conta não encontrada", ContaService.class.getName()));
    }

    public void deletarConta(int id){
        Conta contaObj = getContaById(id);
        if (contaObj == null){
            throw new ObjectNotFoundException("Conta não encontrada", ContaService.class.getName());
        }else {
            contaRepository.deleteById(id);
        }
    }

}
