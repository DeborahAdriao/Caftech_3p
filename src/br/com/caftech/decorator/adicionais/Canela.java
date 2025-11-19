package br.com.caftech.decorator.adicionais;
import br.com.caftech.decorator.BebidaAbstrata;
import br.com.caftech.singleton.CardapioSingleton;

public class Canela extends AdicionalDecorator{
    private double precoAdicional;

    public Canela (BebidaAbstrata bebida){
        super(bebida);
        this.precoAdicional = CardapioSingleton.getInstancia().getPrecoItem("canela");
    }
    @Override
    public String getDescricao() {
        return bebida.getDescricao() + ", com Canela";
    }

    @Override
    public double getCusto() {
        return bebida.getCusto() + this.precoAdicional;
    }

}
