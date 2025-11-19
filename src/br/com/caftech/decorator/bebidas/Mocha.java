package br.com.caftech.decorator.bebidas;
import br.com.caftech.decorator.Bebida;

public class Mocha extends Bebida {
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
