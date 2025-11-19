package br.com.caftech.decorator.bebidas;
import br.com.caftech.decorator.BebidaAbstrata;

public class Mocha extends BebidaAbstrata {
    private double precoBase;

    public Mocha(double preco){
        this.descricao = "Mocha";
        this.precoBase =  preco;
    }
    @Override
    public double getCusto (){
        return this.precoBase;
    }
}
