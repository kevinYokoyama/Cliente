package com.example.ProjetoKevin;

import com.example.ProjetoKevin.core.Adulto;
import com.example.ProjetoKevin.core.Genero;
import com.example.ProjetoKevin.core.Idoso;
import com.example.ProjetoKevin.core.Jovem;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ProjetoKevinApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ProjetoKevinApplication.class, args);
        Scanner input = new Scanner(System.in); //Criando o Scnaeer

        //Instanciando objeto
        var jovem1 = Jovem.builder()
                .nome("Kevin")
                .cpf(22222222222L)
                .banco("C6 Bank")
                .saldo(4000)
                .dtNascimento("09/05/2009")
                .situacaoFinanceira("Positivo")
                .build();

        var adulto1 = Adulto.builder()
                .nome("Rodolfo")
                .cpf(11111111111L)
                .banco("PicPay")
                .saldo(1000)
                .dtNascimento("12/02/1987")
                .risco("Baixo")
                .build();

        var idoso1 = Idoso.builder()
                .nome("Francisco")
                .cpf(33333333333L)
                .banco("Itau")
                .dtNascimento("20/09/1945")
                .genero(Genero.MASCULINO)
                .build();


        //Escolha da faixa etaria
        System.out.println("Digite o numero de acordo com a sua faixa etaria:\n1 - Jovem\n2 - Adulto\n3 - Idoso");
        int faixaEtaria = input.nextInt();

        //Cada faixa etaria tem a sua saida
        switch (faixaEtaria) {
            case 1: //Verificar se colocou um numero entre 1-7
                System.out.println(" ------- Jovem ------ ");
                System.out.println(jovem1.toString());
                System.out.println("\nBem vindo ao local de compra da PicPay!\nAdicione os produtos que você quer comprar:");
                double valorCompra = 0;
                int opcaoMenu = 0;
                while (opcaoMenu !=7) {
                    System.out.println(jovem1.mostrarMenuCompra());
                    opcaoMenu = input.nextInt();
                    switch (opcaoMenu){
                        case 1:
                            System.out.println("Mouse adicionado");
                            valorCompra = valorCompra + 50;
                            break;
                        case 2:
                            System.out.println("Teclado adicionado");
                            valorCompra = valorCompra + 200;
                            break;
                        case 3:
                            System.out.println("RTX 4090 adicionado");
                            valorCompra = valorCompra + 25000;
                            break;
                        case 4:
                            System.out.println("Intel Core i9-14900K adicionado");
                            valorCompra = valorCompra + 3000;
                            break;
                        case 5:
                            System.out.println("MousePad adicionado");
                            valorCompra = valorCompra + 10;
                            break;
                        case 6:
                            System.out.println("Adaptador USB-C para USB adicionado");
                            valorCompra = valorCompra + 5;
                            break;
                        case 7:
                            System.out.println("Compras finalizadas\n");
                            break;
                    }
                }
                System.out.println("Sua compra ficou R$"+valorCompra);
                if (!jovem1.saberSituacaoAtual(valorCompra)) {
                    System.out.println("Você está endividado!\nVocê está devendo "+jovem1.descobrirSaldoPosCompra(valorCompra));
                }else {
                    System.out.println("Você está positivo!\nSaldo atual: "+jovem1.getSaldo());
                }
                break;

            case 2: //Validar se o valor a investir é maior que 0 + validar o switch para escolher o investimento (1-2)
                System.out.println(" ------- Adulto ------ ");
                System.out.println(adulto1.toString());
                System.out.println(adulto1);
                System.out.println("\nBem vindo ao PicPay Investimentos!\nQuantos reais você deseja investir? ");
                double valorInvestir = input.nextDouble();

                if (valorInvestir<adulto1.getSaldo()) {
                    System.out.println("Entre com um valor <= ao seu saldo");
                }
                System.out.println("Quantos reais você deseja depositar por mês? ");
                double depositoMes = input.nextDouble();

                System.out.println("Por quantos meses você deseja investir?");
                int anos = input.nextInt();

                System.out.printf("O seu total investido foi de R$%.2f", adulto1.calcularTotalInvestido(valorInvestir, depositoMes, anos));
                System.out.println("\nOnde você deseja investir? Digite o valor correspondente:\n1 - Poupança\n2 - CDB pré-fixado");
                int escolha = input.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.println("Considerando que ele rende 0,5% ao mês com a Taxa Referencial (TR) de 0,18% ao mês, você vai ter um valor bruto de R$%"+ adulto1.descobrirValorBrutoPoupanca(anos, valorInvestir));
                    case 2:
                        if (valorInvestir<1000) {
                            System.out.println("O valor inicial precisa ser no mínimo R$1000,00");
                        }
                        System.out.println("Considerando que rende 102% do CDI, a taxa do CDI é de 14,90% ao ano e que o período é de 2 anos, o valor bruto vai ser de R$"+adulto1.renderBrutoTotalCDB(valorInvestir));
                }
                break;
            case 3:
                System.out.println(" ------- Idoso ------ ");
                System.out.println(idoso1.toString());
                System.out.println("\nBem vindo ao INSS!");
                System.out.println("Qual foi seu tempo de colaboração?");
                int anosTrabalhados = input.nextInt();
                if (!idoso1.verificarAposentadoria(anosTrabalhados)) {
                    System.out.println("Mulheres: precisa ter no minimo 15 anos de contribuição\nHomens: precisa ter no minimo 20 anos de contribuição");
                }
                System.out.printf("Qual foi a media do seu salario bruto durante esses %d?",anosTrabalhados);
                double salarioBruto = input.nextDouble();
                System.out.printf("Você tem ±R$%.2f no seu FGTS!", idoso1.calcularFgtsTotal(anosTrabalhados, salarioBruto));
                break;
        }
	}
}
