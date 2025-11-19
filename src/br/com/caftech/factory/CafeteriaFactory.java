package br.com.caftech.factory;
import br.com.caftech.decorator.BebidaAbstrata;

public abstract class  CafeteriaFactory {
    public abstract BebidaAbstrata criarBebida();
}
