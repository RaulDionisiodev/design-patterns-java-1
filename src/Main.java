import br.com.alura.loja.desconto.CalculadoraDeDesconto;
import br.com.alura.loja.imposto.CalculadoraDeImpostos;
import br.com.alura.loja.imposto.ISS;
import br.com.alura.loja.imposto.TipoImpostoEnum;
import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // TESTANDO IMPOSTOS
        Orcamento orcamento = new Orcamento(new BigDecimal("100"), 1);

        CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();

        //sem strategy
        System.out.println(calculadora.efetuarCalculo(orcamento, TipoImpostoEnum.ISS));

        //com strategy
        System.out.println(calculadora.efetuarCalculo(orcamento, new ISS()));

        //TESTANDO DESCONTOS
        CalculadoraDeDesconto calculadoraDeDesconto = new CalculadoraDeDesconto();
        Orcamento orcamentoDesconto1 = new Orcamento(new BigDecimal("200"), 6);

        System.out.println(calculadoraDeDesconto.calcular(orcamentoDesconto1));

        Orcamento orcamentoDesconto2 = new Orcamento(new BigDecimal("1000"), 1);

        System.out.println(calculadoraDeDesconto.calcular(orcamentoDesconto2));
    }
}