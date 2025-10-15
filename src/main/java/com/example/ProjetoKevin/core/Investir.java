package com.example.ProjetoKevin.core;

public interface Investir {
    double calcularAportesMes(double depositoMes, int anos);
    double calcularTotalInvestido(double valorInvestir, double depositoMes, int anos);
    double descobrirValorBrutoPoupanca(int anos, double valorInvestir);
    double calcularTaxaRendimentoMensalPoupanca();
    double calcularTaxaBrutaAnualCDB();
    double renderBrutoTotalCDB(double valorInvestir);
    }
