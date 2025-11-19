package br.com.caftech.decorator.adicionais;
import br.com.caftech.decorator.BebidaAbstrata;
import br.com.caftech.singleton.CardapioSingleton;

public class Granulado extends AdicionalDecorator{
    private double precoAdicional;

    public Granulado (BebidaAbstrata bebida){
        super(bebida);
        this.precoAdicional = CardapioSingleton.getInstancia().getPrecoItem("granulado");
    }
    @Override
    public String getDescricao(){
        return bebida.getDescricao() + ", com Granulado";
    }
    @Override
    public double getCusto(){
        return bebida.getCusto() + this.precoAdicional;
    }
}
