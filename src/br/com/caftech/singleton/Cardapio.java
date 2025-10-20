package br.com.caftech.singleton;
import java.io.*; // Para Input/Output de arquivos
import java.util.HashMap; //dicionario de dados (chave - valor)
import java.util.Map; //caderno para anotar (dicionario)
//Você importa o Map para definir o tipo e o HashMap para criar o objeto.

public class Cardapio {
    // 1. Instância única e estática (criada assim que a classe é carregada)
    private static final Cardapio instancia = new Cardapio();

    // 2. Nome do arquivo de persistência
    private static final String ARQUIVO_CARDAPIO = "cardapio.dat";

    // 3. O estado que o Singleton gerencia
    private Map<String, Double> precosItens;

    // 4. Construtor privado: Ninguém de fora pode criar o Cardapio
    private Cardapio() {
        // Tenta carregar o cardápio do arquivo
        carregarCardapio();

        // Se o carregamento falhar ou o arquivo não existir, cria um mapa vazio
        if (precosItens == null) {
            precosItens = new HashMap<>();
            // Você pode adicionar itens padrão aqui se quiser, ex:
            // precosItens.put("expresso", 5.00);
            // salvarCardapio(); // Salva os itens padrão
        }
    }
    // 5. Metodo de acesso global (o único jeito de pegar o Cardapio)
    public static Cardapio getInstancia() {
        return instancia;
    }
    private void carregarCardapio() {
        try (FileInputStream fis = new FileInputStream(ARQUIVO_CARDAPIO);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Lê o mapa inteiro do arquivo e faz o cast
            precosItens = (Map<String, Double>) ois.readObject();
            System.out.println("[Cardapio] Cardápio carregado de " + ARQUIVO_CARDAPIO);

        } catch (FileNotFoundException e) {
            System.out.println("[Cardapio] Arquivo " + ARQUIVO_CARDAPIO + " não encontrado. Um novo será criado.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("[Cardapio] Erro ao carregar cardápio: " + e.getMessage());
        }
    }

    private void salvarCardapio() {
        try (FileOutputStream fos = new FileOutputStream(ARQUIVO_CARDAPIO);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            // Salva o objeto 'precosItens' (o Mapa) inteiro no arquivo
            oos.writeObject(precosItens);
            System.out.println("[Cardapio] Cardápio salvo em " + ARQUIVO_CARDAPIO);

        } catch (IOException e) {
            System.err.println("[Cardapio] Erro ao salvar cardápio: " + e.getMessage());
        }
    }
    public double getPrecoItem(String nomeItem) {
        String chave = nomeItem.toLowerCase().trim();
        return precosItens.getOrDefault(chave, 0.0);
    }
    public void listarItens() {
        System.out.println("--- Cardápio CafTech ---");
        if (precosItens.isEmpty()) {
            System.out.println(" (Cardápio vazio)");
        } else {
            // Itera pelo mapa e imprime cada item
            for (Map.Entry<String, Double> entry : precosItens.entrySet()) {
                System.out.printf("  - %-20s: R$ %.2f\n", entry.getKey(), entry.getValue());
            }
        }
        System.out.println("-------------------------");
    }
}
