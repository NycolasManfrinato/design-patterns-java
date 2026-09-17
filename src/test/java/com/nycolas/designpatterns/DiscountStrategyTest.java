package com.nycolas.designpatterns;

import com.nycolas.designpatterns.strategy.NoDiscountStrategy;
import com.nycolas.designpatterns.strategy.RegularCustomerDiscount;
import com.nycolas.designpatterns.strategy.VipCustomerDiscount;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountStrategyTest {

    private final BigDecimal valor = new BigDecimal("100.00");

    @Test
    void semDescontoMantemValorOriginal() {
        assertEquals(new BigDecimal("100.00"), new NoDiscountStrategy().applyDiscount(valor));
    }

    @Test
    void clienteRegularRecebeDezPorCentoDeDesconto() {
        assertEquals(new BigDecimal("90.00"), new RegularCustomerDiscount().applyDiscount(valor));
    }

    @Test
    void clienteVipRecebeVinteECincoPorCentoDeDesconto() {
        assertEquals(new BigDecimal("75.00"), new VipCustomerDiscount().applyDiscount(valor));
    }
}
