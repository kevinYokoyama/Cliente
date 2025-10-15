package com.example.ProjetoKevin.core;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Jovem extends Cliente implements Gastar {
    private String situacaoFinanceira;
    public Jovem(String nome, long cpf, String banco, double saldo, String dtNascimento, String situacaoFinanceira) {
        super(nome, cpf, banco, saldo, dtNascimento);
        this.situacaoFinanceira=situacaoFinanceira;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "\nSituação financeira: %s", situacaoFinanceira);
    }

    @Override
    public double descobrirSaldoPosCompra(double valorCompra) {
        this.saldo = this.saldo - valorCompra;
        return this.saldo;
    }

    @Override
    public boolean SaberSituacaoAtual(double valorCompra) {
        if (this.descobrirSaldoPosCompra(valorCompra) < 0) {
            this.situacaoFinanceira="Saldo negativo";
            return false;
        }
        this.situacaoFinanceira="Saldo positivo";
        return true;
    }

    @Override
    public String MostrarMenuCompra() {
        return "Menu de compras: \n1 - Mouse (R$50,00)\n2 - Teclado (R$200,00)\n3 - RTX 4090 (R$25000,00)\n4 - Intel Core i9-14900K (R$3000,00)\n5 - MousePad (R$10,00)\n6 - Adaptador USB-C para USB (R$5,00)\n7 - Finalizar compra";
    }
}
