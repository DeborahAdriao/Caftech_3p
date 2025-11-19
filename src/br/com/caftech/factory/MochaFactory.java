package br.com.caftech.factory;
import br.com.caftech.decorator.BebidaAbstrata;
import br.com.caftech.decorator.bebidas.Mocha;
import br.com.caftech.singleton.CardapioSingleton;

public class MochaFactory extends CafeteriaFactory {
    @Override
    public BebidaAbstrata criarBebida() {
        double preco = CardapioSingleton.getInstancia().getPrecoItem("Mocha");
        return new Mocha(preco);
    }
}
