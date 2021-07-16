package br.com.alura.leilao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Leilao implements Serializable {

    private final String descricao;
    private final List<Lance> lances;
    private double maiorLance = Double.NEGATIVE_INFINITY;
    private double menorLance = Double.POSITIVE_INFINITY;

    public Leilao(String descricao) {
        this.descricao = descricao;
        this.lances = new ArrayList<>();
    }

    public String getDescricao() {
        return descricao;
    }

    public void propoe(Lance lance){
        lances.add(lance);
        Collections.sort(lances);
        double valor = lance.getValor();
        calculaMaiorLance(valor);
        calculaMenorLance(valor);

    }

    private void calculaMenorLance(double valor) {
        if (valor < menorLance) menorLance = valor;
    }

    private void calculaMaiorLance(double valor) {
        if (valor > maiorLance) maiorLance = valor;
    }

    public double getMaiorLance(){
        return maiorLance;
    }

    public double getMenorLance() {
        return menorLance;
    }

    public List<Lance> tresMaioresLances() {
        int quantidadeMaximaLances = lances.size();

        if (quantidadeMaximaLances > 3) quantidadeMaximaLances = 3;

        return lances.subList(0,quantidadeMaximaLances);
    }
}
