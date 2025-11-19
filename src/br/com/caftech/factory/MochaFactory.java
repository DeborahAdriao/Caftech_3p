package br.com.caftech.factory;
import br.com.caftech.decorator.Bebida;
import br.com.caftech.decorator.bebidas.Mocha;
import br.com.caftech.singleton.CardapioSingleton;

public class MochaFactory extends CafeteriaFactory {
    @Override
    public Bebida criarBebida() {
        double preco = CardapioSingleton.getInstancia().getPrecoItem("Mocha");
        return new Mocha(preco);
    }
}
