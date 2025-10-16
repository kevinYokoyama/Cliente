package com.example.ProjetoKevin.core;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class Idoso extends Cliente implements Usufruir {
    private Genero genero;
    public Idoso(String nome, long cpf, String banco, String dtNascimento, Genero genero) {
        super(nome, cpf, banco, dtNascimento);
        this.genero = genero;
    }

    @Override
    public String toString() {
        return String.format("Bem vindo, %s portador do CPF %d, nascido em %s.\nBanco: %s\nGenero: %s", nome, cpf, dtNascimento, banco, genero);
    }

    @Override
    public boolean verificarAposentadoria(int anosTrabalhados) {
        if (this.genero == Genero.Masculino)
            return verificarAnosMasc(anosTrabalhados);
        if (this.genero == Genero.FEMININO)
            return verificarAnosFemin(anosTrabalhados);
        return false;
    }

    @Override
    public boolean verificarAnosMasc(int anosTrabalhados) {
        return anosTrabalhados >= 20;
    }

    @Override
    public boolean verificarAnosFemin(int anosTrabalhados) {
        return anosTrabalhados >= 15;
    }

    @Override
    public double calcularFgtsTotal(int anosTrabalhados, double salarioBruto) {
        double fgts = 0;
        double depositoMensal;
        for (int i = 0;i < anosTrabalhados * 12;i++) {
            depositoMensal = anosTrabalhados * 0.08;
            fgts = fgts + depositoMensal;
        }
        return fgts;
    }
}
