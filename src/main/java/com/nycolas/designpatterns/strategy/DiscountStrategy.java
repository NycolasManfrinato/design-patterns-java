package com.nycolas.designpatterns.strategy;

import java.math.BigDecimal;

/**
 * Padrao Strategy.
 *
 * Define uma familia de algoritmos de calculo de desconto,
 * encapsula cada um deles e os torna intercambiaveis em tempo de
 * execucao, sem que o codigo cliente (OrderFacade) precise conhecer
 * a regra concreta aplicada.
 */
public interface DiscountStrategy {

    BigDecimal applyDiscount(BigDecimal valorOriginal);

    String getDescricao();
}
