package br.com.alura.loja.pedido;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.acao.EnviarEmailPedido;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

import java.time.LocalDateTime;
import java.util.List;

//Executa a ação
public class GeraPedidoHandler {

    private List<AcaoAposGerarPedido> acoes;
    //Construtor com injeção de dependências (repository, daos e etc)
    public GeraPedidoHandler() {
    }

    public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
        this.acoes = acoes;
    }

    public void executa(GeraPedido dados) {
        Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeItens());

        Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);

       /*
        ---- Vamos criar classes para representar essas funcionalidades
        ---- Caso essas funcionalidades ficassem aqui a classe perderia coesão


       System.out.println("Salavar no BD");
       System.out.println("Enviar email com dados do pedido");
        */

        acoes.forEach(a -> a.executarAcao(pedido));

    }
}
