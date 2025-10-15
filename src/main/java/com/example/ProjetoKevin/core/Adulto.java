package com.example.ProjetoKevin.core;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class Adulto extends Cliente implements Investir{
    private String risco;
    public Adulto(String nome, long cpf, String banco, double saldo, String dtNascimento, String risco){
        super(nome, cpf, banco, saldo, dtNascimento);
        this.risco=risco;
    }

    @Override
    public String toString() {
        return String.format(super.toString()+"\nRisco de investimento: %s", risco);
    }

    @Override
    public double calcularAportesMes(double depositoMes, int anos) {
        return depositoMes*(anos*12);
    }

    @Override
    public double calcularTotalInvestido(double valorInvestir, double depositoMes, int anos) {
        return valorInvestir+this.calcularAportesMes(depositoMes, anos);
    }

    @Override
    public double descobrirValorBrutoPoupanca(int anos, double valorInvestir) {
        double porMes = 0;
        for (int i = 0; i <= anos * 12; i++) {
            porMes = valorInvestir * this.calcularTaxaRendimentoMensalPoupanca();
        }
        return porMes;
    }

    @Override
    public double calcularTaxaRendimentoMensalPoupanca() {
        double taxaRendimento = 0.5 + 0.18;
        taxaRendimento = taxaRendimento + 1;
        return taxaRendimento;
    }

    @Override
    public double calcularTaxaBrutaAnualCDB() {
        return 0.1490 * 1.02;
    }

    @Override
    public double renderBrutoTotalCDB(double valorInvestir) {
        double rendimento = 0;
        for (int i = 0; i < 1; i++) {
            rendimento = valorInvestir * this.calcularTaxaBrutaAnualCDB();
        }
        return rendimento;
    }
}
