package br.com.caftech.decorator.adicionais;
import br.com.caftech.decorator.Bebida;
import br.com.caftech.singleton.Cardapio;

public class Chocolate extends AdicionalDecorator{
    private double precoAdicional;

    public Chocolate (Bebida bebida){
        super(bebida);
        this.precoAdicional = Cardapio.getInstancia().getPrecoItem("chocolate");
    }
    @Override
    public String getDescricao() {
        return bebida.getDescricao() + ", com Chocolate";
    }

    @Override
    public double getCusto() {
        return bebida.getCusto() + this.precoAdicional;
    }

}
