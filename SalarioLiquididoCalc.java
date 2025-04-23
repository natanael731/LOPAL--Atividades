package estudojava;

import java.util.Scanner;

public class SalarioLiquididoCalc {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Informe seu salário bruto: R$");
        double sb = sc.nextDouble();

        System.out.println("Tipo de plano de saúde: (basico/padrao/premium):");
        String ps = sc.next();

        System.out.println("Número de dependentes:");
        int dep = sc.nextInt();

        System.out.println("Recebe vale transporte? (sim/nao): ");
        boolean vt = sc.next().equalsIgnoreCase("sim");

        System.out.print("Recebe vale alimentação? (sim/nao): ");
        boolean valeAlimentacao = sc.next().equalsIgnoreCase("sim");

        System.out.print("Recebe vale refeição? (sim/nao): ");
        boolean valeRefeicao = sc.next().equalsIgnoreCase("sim");

        // Calcular descontos fixos
        double descontoPlano = switch (ps.toLowerCase()) {
            case "basico" -> 100;
            case "padrao" -> 200;
            case "premium" -> 300;
            default -> 0;
        };

        double descontoVT = vt ? sb * 0.06 : 0;
        double descontoVA = valeAlimentacao ? 120 : 0;
        double descontoVR = valeRefeicao ? 200 : 0;

        // Calcular INSS
        double inss = calcularINSS(sb);

        // Base de cálculo para IRRF
        double baseIR = sb - inss - (dep * 189.59);

        // Calcular IRRF
        double irrf = calcularIRRF(baseIR);

        // Soma de todos os descontos
        double totalDescontos = inss + irrf + descontoPlano + descontoVT + descontoVA + descontoVR;

        // Salário líquido
        double salarioLiquido = sb - totalDescontos;

        // Percentual de desconto
        double percentualDesconto = (totalDescontos / sb) * 100;

        // Exibir resultados
        System.out.printf("Salário líquido: R$ %.2f%n", salarioLiquido);
        System.out.printf("Percentual de descontos: %.2f%%%n", percentualDesconto);

        sc.close();
    }

    // Função para calcular INSS
    public static double calcularINSS(double salario) {
        if (salario <= 1412.00) return salario * 0.075;
        else if (salario <= 2666.68) return salario * 0.09;
        else if (salario <= 3999.99) return salario * 0.12;
        else return salario * 0.14;
    }

    // Função para calcular IRRF
    public static double calcularIRRF(double base) {
        if (base <= 2112.00) return 0;
        else if (base <= 2826.65) return base * 0.075 - 158.40;
        else if (base <= 3751.05) return base * 0.15 - 370.40;
        else if (base <= 4664.68) return base * 0.225 - 651.73;
        else return base * 0.275 - 884.96;
    }
}