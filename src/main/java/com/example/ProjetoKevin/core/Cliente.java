package com.example.ProjetoKevin.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
public abstract class Cliente {
    protected String nome;
    protected long cpf;
    protected String banco;
    protected double saldo;
    protected String dtNascimento;


    public Cliente(String nome, long cpf, String banco, String dtNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.banco = banco;
        this.dtNascimento = dtNascimento;
    }

    public Cliente(String nome, long cpf, String banco, double saldo, String dtNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.banco = banco;
        this.saldo = saldo;
        this.dtNascimento = dtNascimento;
    }

    public String toString() {
        return String.format("Bem vindo, %s portador do CPF %d, nascido em %s.\nBanco: %s\nSaldo: %.2f", nome, cpf, dtNascimento, banco, saldo);
    }
}
