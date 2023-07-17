package br.com.banco.controller;

import br.com.banco.model.Transferencia;
import br.com.banco.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/banco/transferencias")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @GetMapping
    public List<Transferencia> getListaTransferencias(){
        return transferenciaService.getListaTransferencias();
    }

    @GetMapping("/{id}")
    public Transferencia getTransferenciaById(@PathVariable int id){
        return transferenciaService.getTransferenciaById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transferencia novaTransferencia(@RequestBody @Validated Transferencia transferencia){
        return transferenciaService.novaTransferencia(transferencia);
    }

    @GetMapping("/pesquisa")
    public List<Transferencia> getByNomeAndDate(
            @RequestParam(value = "operador", defaultValue = "") String nomeOperador,
            @RequestParam(value = "inicio", defaultValue = "") Date inicio,
            @RequestParam(value = "fim", defaultValue = "") Date fim) {
        return transferenciaService.filtrarTransferencia(nomeOperador, inicio, fim);
    }

}
