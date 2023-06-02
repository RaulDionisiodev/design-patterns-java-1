import br.com.alura.loja.imposto.CalculadoraDeImpostos;
import br.com.alura.loja.imposto.ISS;
import br.com.alura.loja.imposto.TipoImpostoEnum;
import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Orcamento orcamento = new Orcamento(new BigDecimal("100"));

        CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();

        //sem strategy
        System.out.println(calculadora.calcular(orcamento, TipoImpostoEnum.ISS));

        //com strategy
        System.out.println(calculadora.calcular(orcamento, new ISS()));
    }
}