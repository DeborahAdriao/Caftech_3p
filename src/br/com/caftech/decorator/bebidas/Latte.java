package br.com.caftech.decorator.bebidas;
import br.com.caftech.decorator.BebidaAbstrata;

public class Latte extends BebidaAbstrata {
    private double precoBase;

    public Latte(double preco){
        this.descricao = "Latte";
        this.precoBase = preco;
    }
    @Override
    public double getCusto() {
        return this.precoBase;
    }
}
