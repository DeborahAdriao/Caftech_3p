package br.com.caftech.decorator.bebidas;
import br.com.caftech.decorator.BebidaAbstrata;

public class CafeGourmet extends BebidaAbstrata {
    private double precoBase;

    public CafeGourmet(double preco){
        this.descricao = "Café Gourmet";
        this.precoBase = preco;
    }
    @Override
    public double getCusto() {
        return this.precoBase;
    }
}
