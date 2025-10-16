package com.example.ProjetoKevin.core;

public interface Operacao {
    double descobrirSaldoPosCompra(double valorCompra);
    boolean saberSituacaoAtual(double valorCompra);
    String mostrarMenuCompra();
}
