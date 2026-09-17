package com.nycolas.designpatterns;

import com.nycolas.designpatterns.facade.OrderFacade;
import com.nycolas.designpatterns.strategy.NoDiscountStrategy;
import com.nycolas.designpatterns.strategy.RegularCustomerDiscount;
import com.nycolas.designpatterns.strategy.VipCustomerDiscount;

import java.math.BigDecimal;

/**
 * Desafio de projeto - DIO
 * Trilha: Itau Java com Inteligencia Artificial
 * Modulo: Explorando Padroes de Projeto na Pratica com Java
 *
 * Demonstra, em um unico fluxo de "fechamento de pedido", tres
 * padroes de projeto GoF trabalhados no bootcamp:
 *   - Singleton -> com.nycolas.designpatterns.singleton.AppConfig
 *   - Strategy  -> com.nycolas.designpatterns.strategy.*
 *   - Facade    -> com.nycolas.designpatterns.facade.OrderFacade
 */
public class Main {

    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();

        orderFacade.fecharPedido(
                "Nycolas",
                "Teclado Mecanico",
                2,
                new BigDecimal("350.00"),
                new NoDiscountStrategy()
        );

        orderFacade.fecharPedido(
                "Maria",
                "Mouse Gamer",
                1,
                new BigDecimal("180.00"),
                new RegularCustomerDiscount()
        );

        orderFacade.fecharPedido(
                "Joao",
                "Monitor 27\"",
                3,
                new BigDecimal("1200.00"),
                new VipCustomerDiscount()
        );
    }
}
