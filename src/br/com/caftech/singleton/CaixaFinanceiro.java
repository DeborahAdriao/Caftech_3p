package br.com.caftech.singleton;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CaixaFinanceiro {
    // 1. Instância única
    private static final CaixaFinanceiro instancia = new CaixaFinanceiro();

    // 2. Nome do arquivo de persistência
    private static final String ARQUIVO_PEDIDOS = "pedidos.dat";

    // 3. Estado que o Singleton gerencia
    private List<Pedido> historicoPedidos;
    private double saldoTotal; // Saldo é volátil, recalculado ao carregar

    // 4. Construtor privado
    private CaixaFinanceiro() {
        // Tenta carregar o histórico de pedidos do arquivo
        carregarHistorico();

        // Se falhar, começa um histórico novo
        if (historicoPedidos == null) {
            historicoPedidos = new ArrayList<>();
        }

        // Recalcula o saldo total com base no histórico carregado
        recalcularSaldoTotal();
        System.out.printf("[Caixa] Caixa aberto com saldo de R$ %.2f (baseado em %d pedidos)\n",
                saldoTotal, historicoPedidos.size());
    }

    // 5. Método de acesso global
    public static CaixaFinanceiro getInstancia() {
        return instancia;
    }

    private void carregarHistorico() {
        try (FileInputStream fis = new FileInputStream(ARQUIVO_PEDIDOS);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Lê a lista inteira do arquivo
            historicoPedidos = (List<Pedido>) ois.readObject();
            System.out.println("[Caixa] Histórico de pedidos carregado.");

        } catch (FileNotFoundException e) {
            System.out.println("[Caixa] Arquivo " + ARQUIVO_PEDIDOS + " não encontrado.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("[Caixa] Erro ao carregar histórico: " + e.getMessage());
        }
    }

    private void salvarHistorico() {
        try (FileOutputStream fos = new FileOutputStream(ARQUIVO_PEDIDOS);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            // Salva o objeto 'historicoPedidos' (a Lista) inteiro no arquivo
            oos.writeObject(historicoPedidos);
            // System.out.println("[Caixa] Histórico de pedidos salvo."); // Opcional

        } catch (IOException e) {
            System.err.println("[Caixa] Erro ao salvar histórico: " + e.getMessage());
        }
    }

    public void registrarVenda(Pedido pedido) {
        historicoPedidos.add(pedido);
        saldoTotal += pedido.getValorTotal();

        // Salva o histórico *a cada* venda
        salvarHistorico();

        System.out.printf("[Caixa] Venda registrada. Novo saldo: R$ %.2f\n", saldoTotal);
    }

    private void recalcularSaldoTotal() {
        this.saldoTotal = 0;
        for (Pedido p : historicoPedidos) {
            this.saldoTotal += p.getValorTotal();
        }
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public void listarHistorico() {
        System.out.println("--- Histórico de Vendas CafTech ---");
        if (historicoPedidos.isEmpty()) {
            System.out.println(" (Nenhuma venda registrada)");
        } else {
            for (Pedido p : historicoPedidos) {
                System.out.println("  " + p.toString()); // Usa o toString() do Pedido
            }
        }
        System.out.printf("--- Saldo Total em Caixa: R$ %.2f ---\n", saldoTotal);
    }
}
