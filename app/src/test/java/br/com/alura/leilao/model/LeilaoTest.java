package br.com.alura.leilao.model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LeilaoTest {
    public static final double DELTA = 0.0001;
    private final Leilao CONSOLE = new Leilao("Console");
    private final Usuario USUARIO_TESTE = new Usuario("João");

    @Test
    public void getDescricao_QuandoRecebeDescricao_DevolveDescricao() {
        //executar ação esperada
        String descricaoDevolvida = CONSOLE.getDescricao();
        // restar resultado
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void getMaiorLance_QuandoRecebeApenasUmLance_DevolveMaiorLance(){
        CONSOLE.propoe(new Lance(USUARIO_TESTE, 100.0));

        double maiorLance = CONSOLE.getMaiorLance();

        assertEquals(maiorLance, 100, DELTA);
    }

    @Test
    public void getMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente_DevolveMaiorLance(){
        CONSOLE.propoe(new Lance(USUARIO_TESTE, 100.0));
        CONSOLE.propoe(new Lance(new Usuario("Maria"), 150.0));

        double maiorLance = CONSOLE.getMaiorLance();

        assertEquals(maiorLance, 150.0, DELTA);
    }

    @Test
    public void getMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente_DevolveMaiorLance(){
        CONSOLE.propoe(new Lance(USUARIO_TESTE, 150.0));
        CONSOLE.propoe(new Lance(new Usuario("Maria"), 100.0));

        double maiorLance = CONSOLE.getMaiorLance();

        assertEquals(maiorLance, 150.0, DELTA);
    }


    @Test
    public void deve_DevolveMenorLance_QuandoRecebeApenasUmLance(){
        CONSOLE.propoe(new Lance(USUARIO_TESTE, 100.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(menorLanceDevolvido, 100, DELTA);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente(){
        CONSOLE.propoe(new Lance(new Usuario("Maria"), 100.0));
        CONSOLE.propoe(new Lance(USUARIO_TESTE, 150.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(menorLanceDevolvido, 100.0, DELTA);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente(){
        CONSOLE.propoe(new Lance(USUARIO_TESTE, 150.0));
        CONSOLE.propoe(new Lance(new Usuario("Maria"), 100.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(menorLanceDevolvido, 100.0, DELTA);
    }

    @Test
    public void deve_DevolverTresMaioresLances_QuandoRecebeExatosTresLances(){
        CONSOLE.propoe(new Lance(USUARIO_TESTE, 100.0));
        CONSOLE.propoe(new Lance(USUARIO_TESTE, 200.0));
        CONSOLE.propoe(new Lance(USUARIO_TESTE, 200.0));
        CONSOLE.propoe(new Lance(USUARIO_TESTE, 300.0));
        CONSOLE.propoe(new Lance(USUARIO_TESTE, 400.0));
        CONSOLE.propoe(new Lance(USUARIO_TESTE, 400.0));

        List<Lance> tresMaioresLances = CONSOLE.tresMaioresLances();

        assertEquals(3, tresMaioresLances.size());
        assertEquals(400, tresMaioresLances.get(0).getValor(), DELTA);
        assertEquals(400, tresMaioresLances.get(1).getValor(), DELTA);
        assertEquals(300, tresMaioresLances.get(2).getValor(), DELTA);
    }

    @Test
    public void deve_DevolverTresMaioresLances_QuandoNaoRecebeLances(){
        List<Lance> tresMaioresLances = CONSOLE.tresMaioresLances();
        assertEquals(0, tresMaioresLances.size());
    }

    @Test
    public void deve_DevolverTresMaioresLances_QuandoRecebeUmLance(){
        CONSOLE.propoe(new Lance(USUARIO_TESTE, 100.0));

        List<Lance> tresMaioresLances = CONSOLE.tresMaioresLances();

        assertEquals(1, tresMaioresLances.size());
        assertEquals(100.0, tresMaioresLances.get(0).getValor(), DELTA);
    }

    @Test
    public void deve_DevolverTresMaioresLances_QuandoRecebeDoisLances(){
        CONSOLE.propoe(new Lance(USUARIO_TESTE, 100.0));
        CONSOLE.propoe(new Lance(USUARIO_TESTE, 200.0));

        List<Lance> tresMaioresLances = CONSOLE.tresMaioresLances();

        assertEquals(2, tresMaioresLances.size());
        assertEquals(200.0, tresMaioresLances.get(0).getValor(), DELTA);
        assertEquals(100.0, tresMaioresLances.get(1).getValor(), DELTA);
    }
}

//[nome do método] [Estado de Teste] [Resultado esperado]