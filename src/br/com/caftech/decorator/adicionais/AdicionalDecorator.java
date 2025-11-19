package br.com.caftech.decorator.adicionais;
import br.com.caftech.decorator.BebidaAbstrata;

public abstract class AdicionalDecorator extends BebidaAbstrata {
    protected BebidaAbstrata bebida;
    public AdicionalDecorator(BebidaAbstrata bebida){
        this.bebida = bebida;
    }
    @Override
    public abstract String getDescricao();
}
