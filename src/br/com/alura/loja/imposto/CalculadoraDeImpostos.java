package br.com.alura.loja.imposto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDeImpostos {

    //Calcula o valor do imposto para cada orçamento de acordo com a alíquota de imposto
    public BigDecimal efetuarCalculo(Orcamento orcamento, TipoImpostoEnum tipoImposto) {

        // Funciona, porém ficará cada vez maior sempre que um novo imposto for criado, pois será necessário
        // colocar um novo case aqui
        switch (tipoImposto) {
            case ICMS:
                return orcamento.getValor().multiply(new BigDecimal("0.1"));
            case ISS:
                return orcamento.getValor().multiply(new BigDecimal("0.6"));
            default:
                return BigDecimal.ZERO;
        }
    }

    //Para solucionar vamos criar uma classe para cada imposto ao invés de passar o enum
    public BigDecimal efetuarCalculo(Orcamento orcamento, Imposto imposto) {
        return imposto.efetuarCalculo(orcamento);
    }

    /*
    * agora se surgirem novos impostos na aplicação nós não precisamos mais mexer na calculadora,
    * o código dela vai continuar intacto, vai continuar tendo apenas uma única linha.
    * E cada classe de imposto vai ter a sua implementação em específica.
    * Então o código de cada classe também fica pequeno, também fica bem coeso*/
}
