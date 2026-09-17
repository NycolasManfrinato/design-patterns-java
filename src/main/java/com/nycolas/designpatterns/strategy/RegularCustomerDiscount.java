package com.nycolas.designpatterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** Cliente regular: 10% de desconto. */
public class RegularCustomerDiscount implements DiscountStrategy {

    private static final BigDecimal PERCENTUAL = new BigDecimal("0.10");

    @Override
    public BigDecimal applyDiscount(BigDecimal valorOriginal) {
        BigDecimal desconto = valorOriginal.multiply(PERCENTUAL);
        return valorOriginal.subtract(desconto).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String getDescricao() {
        return "Cliente regular (10% de desconto)";
    }
}
