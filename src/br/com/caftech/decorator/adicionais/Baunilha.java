package br.com.caftech.decorator.adicionais;
import br.com.caftech.decorator.BebidaAbstrata;
import br.com.caftech.singleton.CardapioSingleton;

public class Baunilha extends AdicionalDecorator{
    private double precoAdicional;

    public Baunilha(BebidaAbstrata bebida) {
        super(bebida);
        // CONEXÃO: Busca seu próprio preço no Cardapio
        this.precoAdicional = CardapioSingleton.getInstancia().getPrecoItem("baunilha");
    }
    @Override
    public String getDescricao() {
        return bebida.getDescricao() + ", com Baunilha";
    }
    @Override
    public double getCusto(){
        // CONEXÃO: Soma o custo da bebida embrulhada com seu preço
        return bebida.getCusto() + this.precoAdicional;
    }
}
