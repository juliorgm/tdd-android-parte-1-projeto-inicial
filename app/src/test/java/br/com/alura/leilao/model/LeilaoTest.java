package br.com.alura.leilao.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeilaoTest {
    private final Leilao console = new Leilao("Console");
    private final Usuario joao = new Usuario("João");

    @Test
    public void getDescricao_QuandoRecebeDescricao_DevolveDescricao() {
        //executar ação esperada
        String descricaoDevolvida = console.getDescricao();
        // restar resultado
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void getMaiorLance_QuandoRecebeApenasUmLance_DevolveMaiorLance(){
        console.propoe(new Lance(joao, 100.0));

        double maiorLance = console.getMaiorLance();

        assertEquals(maiorLance, 100, 0.0001);
    }

    @Test
    public void getMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente_DevolveMaiorLance(){
        console.propoe(new Lance(joao, 100.0));
        console.propoe(new Lance(new Usuario("Maria"), 150.0));

        double maiorLance = console.getMaiorLance();

        assertEquals(maiorLance, 150.0, 0.0001);
    }

    @Test
    public void getMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente_DevolveMaiorLance(){
        console.propoe(new Lance(joao, 150.0));
        console.propoe(new Lance(new Usuario("Maria"), 100.0));

        double maiorLance = console.getMaiorLance();

        assertEquals(maiorLance, 150.0, 0.0001);
    }


    @Test
    public void deve_DevolveMenorLance_QuandoRecebeApenasUmLance(){
        console.propoe(new Lance(joao, 100.0));

        double menorLanceDevolvido = console.getMenorLance();

        assertEquals(menorLanceDevolvido, 100, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente(){
        console.propoe(new Lance(new Usuario("Maria"), 100.0));
        console.propoe(new Lance(joao, 150.0));

        double menorLanceDevolvido = console.getMenorLance();

        assertEquals(menorLanceDevolvido, 100.0, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente(){
        console.propoe(new Lance(joao, 150.0));
        console.propoe(new Lance(new Usuario("Maria"), 100.0));

        double menorLanceDevolvido = console.getMenorLance();

        assertEquals(menorLanceDevolvido, 100.0, 0.0001);
    }
}

//[nome do método] [Estado de Teste] [Resultado esperado]