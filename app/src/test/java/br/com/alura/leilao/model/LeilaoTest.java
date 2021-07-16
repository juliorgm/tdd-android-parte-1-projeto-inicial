package br.com.alura.leilao.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeilaoTest {

    @Test
    public void getDescricao_QuandoRecebeDescricao_DevolveDescricao() {
        //Criar cenário de teste
        Leilao console = new Leilao("Console");
        //executar ação esperada
        String descricaoDevolvida = console.getDescricao();
        // restar resultado
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void getMaiorLance_QuandoRecebeApenasUmLance_DevolveMaiorLance(){
        Leilao console = new Leilao("Console");
        console.propoe(new Lance(new Usuario("João"), 100.0));

        double maiorLance = console.getMaiorLance();

        assertEquals(maiorLance, 100, 0.0001);
    }

    @Test
    public void getMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente_DevolveMaiorLance(){
        Leilao console = new Leilao("PC");
        console.propoe(new Lance(new Usuario("João"), 100.0));
        console.propoe(new Lance(new Usuario("João"), 150.0));

        double maiorLance = console.getMaiorLance();

        assertEquals(maiorLance, 150.0, 0.0001);
    }

    @Test
    public void getMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente_DevolveMaiorLance(){
        Leilao console = new Leilao("PC");
        console.propoe(new Lance(new Usuario("João"), 150.0));
        console.propoe(new Lance(new Usuario("João"), 100.0));

        double maiorLance = console.getMaiorLance();

        assertEquals(maiorLance, 150.0, 0.0001);
    }


    @Test
    public void deve_DevolveMenorLance_QuandoRecebeApenasUmLance(){
        Leilao console = new Leilao("Console");
        console.propoe(new Lance(new Usuario("João"), 100.0));

        double menorLanceDevolvido = console.getMenorLance();

        assertEquals(menorLanceDevolvido, 100, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente(){
        Leilao console = new Leilao("Console");
        console.propoe(new Lance(new Usuario("João"), 100.0));
        console.propoe(new Lance(new Usuario("João"), 150.0));

        double menorLanceDevolvido = console.getMenorLance();

        assertEquals(menorLanceDevolvido, 100.0, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente(){
        Leilao console = new Leilao("Console");
        console.propoe(new Lance(new Usuario("João"), 150.0));
        console.propoe(new Lance(new Usuario("João"), 100.0));

        double menorLanceDevolvido = console.getMenorLance();

        assertEquals(menorLanceDevolvido, 100.0, 0.0001);
    }
}

//[nome do método] [Estado de Teste] [Resultado esperado]