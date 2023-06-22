package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class Desconto {

    protected Desconto proximo;

    public Desconto(Desconto proximo) {
        this.proximo = proximo;
    }

    // No template Method é a classe mãe que verifica qual é o desconto a ser aplicado
    protected abstract BigDecimal efetuarCalculo (Orcamento orcamento);

    // O processo de calcular fica aqui e não nas classes filhas. as classes só tem suas regras específicas
    // a regra repetida vem pra classe mãe
    public BigDecimal calucular (Orcamento orcamento) {
        if (deveAplicar(orcamento)) {
            return efetuarCalculo(orcamento);
        }

        return proximo.calucular(orcamento);
    }

    public abstract boolean deveAplicar (Orcamento orcamento);
}
