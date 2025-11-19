package br.com.caftech.decorator.bebidas;
import br.com.caftech.decorator.BebidaAbstrata;

public class Cappuccino extends BebidaAbstrata {
    private double precoBase;

    public Cappuccino(double preco){
        this.descricao = "Cappuccino";
        this.precoBase = preco;
    }
    @Override
    public double getCusto() {
        return this.precoBase;
    }
}
