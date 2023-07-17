package br.com.banco.service;

import br.com.banco.model.Transferencia;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class TransferenciaServiceTest {

    @Autowired
    public TransferenciaService transferenciaService;
/*

    @Test
    public void testeGetTransferenciasById(){
        Transferencia testeTransferencia = transferenciaService.getTransferenciaById(1);
        System.out.println(testeTransferencia);
    }

    @Test
    public void testePesquisaTransferencias(){
        List<Transferencia> testePesquisa = transferenciaService.filtrarTransferencia(null, null, null);
        System.out.println(testePesquisa.toString());
    }

 */
}
