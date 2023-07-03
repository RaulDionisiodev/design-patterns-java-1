package br.com.alura.loja.pedido;

import br.com.alura.loja.orcamento.Orcamento;

import java.time.LocalDateTime;

//Executa a ação
public class GeraPedidoHandler {

    //Construtor com injeção de dependências (repository, daos e etc)
    public GeraPedidoHandler() {
    }

    public void executa(GeraPedido dados) {
        Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeItens());

        Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);

        System.out.println("Salavar no BD");

        System.out.println("Enviar email com dados do pedido");

    }
}
