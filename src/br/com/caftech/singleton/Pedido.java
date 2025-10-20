package br.com.caftech.singleton;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Pedido implements Serializable{
    // Adiciona um serialVersionUID para controlar a versão da classe
    private static final long serialVersionUID = 1L;

    // Nota: Não guardamos o objeto Bebida,
    // pois objetos decorados são complexos para serializar.
    // Guardamos os *resultados* (descrição e custo).
    private String descricaoBebida;
    private double valorTotal;
    private String metodoPagamento;
    private LocalDateTime dataHora;

    public Pedido(String descricaoBebida, double valorTotal, String metodoPagamento) {
        this.descricaoBebida = descricaoBebida;
        this.valorTotal = valorTotal;
        this.metodoPagamento = metodoPagamento;
        this.dataHora = LocalDateTime.now(); // Grava a data e hora exatas da venda
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - Método: %s - Total: R$ %.2f",
                dataHora.toLocalDate(),
                descricaoBebida,
                metodoPagamento,
                valorTotal);
    }
}
