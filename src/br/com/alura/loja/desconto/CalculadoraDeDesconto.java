package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDeDesconto {

    public BigDecimal calcular (Orcamento orcamento) {

        //Caso as regras de desconto aumentem teremos muitos ifs aqui
        //Não conseguimos usar o strategy aqui porque não sabemos qual o desconto aplicar, precisaríamos do
        // if-else da mesma forma.

       /* if (orcamento.getQuantidadeItens() > 5) {
            return orcamento.getValor().multiply(new BigDecimal("0.1"));
        }

        if (orcamento.getValor().compareTo(new BigDecimal("500")) > 0) {
            return orcamento.getValor().multiply(new BigDecimal("0.1"));
        } */

        // Para resolver extraímos as lógicas de cada if para classes diferentes (uma classe para cada if)
        // Cada classe testa o se aplica ou não o desconto e, se não aplicar chama a próxima
        // até a classe SemDesconto que somente retorna zero

         Desconto cadeiaDeDecontos = new DescontoParaOrcamentoComMaisDeCincoItens(
                 new DescontoParaOrcamentoMaiorQueQuinhentos(new SemDesconto()));

        return cadeiaDeDecontos.calucular(orcamento);
    }
}
