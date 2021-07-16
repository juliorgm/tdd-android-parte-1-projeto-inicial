package br.com.alura.leilao.model;

import java.io.Serializable;
import java.util.ArrayList;
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
        double valor = lance.getValor();
        if (valor > maiorLance) maiorLance = valor;
        if (valor < menorLance) menorLance = valor;

    }

    public double getMaiorLance(){
        return maiorLance;
    }

    public double getMenorLance() {
        return menorLance;
    }
}
