package com.example.ProjetoKevin.core;

public interface Usufruir {
    boolean verificarAposentadoria(int anosTrabalhados);
    boolean verificarAnosMasc(int anosTrabalhados);
    boolean verificarAnosFemin(int anosTrabalhados);
    double calcularFgtsTotal(int anosTrabalhados, double salarioBruto);

}
