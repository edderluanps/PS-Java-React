package br.com.banco.controller;

import br.com.banco.model.Conta;
import br.com.banco.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banco/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public List<Conta> getListaContas() {
        return contaService.getListaContas();
    }

    @GetMapping("/{id}")
    public Conta getContaById(@PathVariable int id) {
        return contaService.getContaById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conta salvarConta(@RequestBody @Validated Conta conta){
        return contaService.salvarConta(conta);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarConta(@PathVariable int id, @RequestBody Conta conta){
        contaService.atualizarConta(id, conta);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarConta(@PathVariable int id_conta){
        contaService.deletarConta(id_conta);
    }
}
