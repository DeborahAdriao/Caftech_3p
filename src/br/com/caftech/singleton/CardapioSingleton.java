package br.com.caftech.singleton;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CardapioSingleton {

    private static final CardapioSingleton instancia = new CardapioSingleton();
    private static final String ARQUIVO_CARDAPIO = "cardapio.dat";
    private Map<String, Double> precosItens;

    private CardapioSingleton() {
        carregarCardapio();
        if (precosItens == null) {
            System.out.println("[Cardapio] Nenhum arquivo encontrado. Criando cardápio padrão...");
            precosItens = new HashMap<>();
        }
        sincronizarItensPadrao();
        salvarCardapio();
    }
    public static CardapioSingleton getInstancia() {
        return instancia;
    }
    private void carregarCardapio() {
        try (FileInputStream fis = new FileInputStream(ARQUIVO_CARDAPIO);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // lê o mapa inteiro do arquivo
            precosItens = (Map<String, Double>) ois.readObject();
            System.out.println("[Cardapio] Cardápio carregado de " + ARQUIVO_CARDAPIO);

        } catch (FileNotFoundException e) {
            // para a primeira vez que o programa roda
            System.out.println("[Cardapio] Arquivo " + ARQUIVO_CARDAPIO + " não encontrado.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("[Cardapio] Erro ao carregar cardápio: " + e.getMessage());
        }
    }
    private void salvarCardapio() {
        try (FileOutputStream fos = new FileOutputStream(ARQUIVO_CARDAPIO);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(precosItens);
            System.out.println("[Cardapio] Cardápio padrão salvo em " + ARQUIVO_CARDAPIO);

        } catch (IOException e) {
            System.err.println("[Cardapio] Erro ao salvar cardápio: " + e.getMessage());
        }
    }
    private void sincronizarItensPadrao() { //metodo de segurança, primeira inicilizaçao

        precosItens.putIfAbsent("expresso", 7.00);
        precosItens.putIfAbsent("cafe gourmet", 13.00);
        precosItens.putIfAbsent("cappuccino", 9.00);
        precosItens.putIfAbsent("latte", 7.00);
        precosItens.putIfAbsent("mocha", 10.00);

        precosItens.putIfAbsent("baunilha", 0.50);
        precosItens.putIfAbsent("chocolate", 2.00);
        precosItens.putIfAbsent("chantily", 2.00);
        precosItens.putIfAbsent("canela", 0.50);
        precosItens.putIfAbsent("granulado", 0.70);
    }
    public double getPrecoItem(String nomeItem){ //metodo q o resto pode acessar
        String chave = nomeItem.toLowerCase().trim();
        double preco = precosItens.getOrDefault(chave, 0.0);

        if (preco == 0.0){
            System.err.println("[Cardapio] AVISO: Item '" + chave + "' não encontrado no cardápio.");
        }
        return preco;
    }
}

