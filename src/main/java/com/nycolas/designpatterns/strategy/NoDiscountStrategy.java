package com.nycolas.designpatterns.strategy;

import java.math.BigDecimal;

/** Cliente sem categoria especial: nenhum desconto aplicado. */
public class NoDiscountStrategy implements DiscountStrategy {

    @Override
    public BigDecimal applyDiscount(BigDecimal valorOriginal) {
        return valorOriginal;
    }

    @Override
    public String getDescricao() {
        return "Sem desconto";
    }
}
