package br.com.caftech.decorator.adicionais;
import br.com.caftech.decorator.BebidaAbstrata;
import br.com.caftech.singleton.CardapioSingleton;

public class Chantily extends AdicionalDecorator{
    private double precoAdicional;

    public Chantily (BebidaAbstrata bebida){
        super(bebida);
        this.precoAdicional = CardapioSingleton.getInstancia().getPrecoItem("chantily");
    }
    @Override
    public String getDescricao() {
        return bebida.getDescricao() + ", com Chantily";
    }

    @Override
    public double getCusto() {
        return bebida.getCusto() + this.precoAdicional;
    }

}
