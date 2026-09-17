package com.nycolas.designpatterns.facade;

import com.nycolas.designpatterns.facade.subsystems.NotificationService;
import com.nycolas.designpatterns.facade.subsystems.PaymentService;
import com.nycolas.designpatterns.facade.subsystems.StockService;
import com.nycolas.designpatterns.singleton.AppConfig;
import com.nycolas.designpatterns.strategy.DiscountStrategy;

import java.math.BigDecimal;

/**
 * Padrao Facade.
 *
 * Oferece uma interface unica e simples ("fecharPedido") para um
 * fluxo que, por baixo dos panos, envolve varios subsistemas
 * (estoque, pagamento, notificacao) e outros padroes ja aplicados no
 * projeto (Singleton para configuracao, Strategy para o desconto).
 * O cliente da Facade nao precisa conhecer os detalhes de cada
 * subsistema para concluir um pedido.
 */
public class OrderFacade {

    private final StockService stockService = new StockService();
    private final PaymentService paymentService = new PaymentService();
    private final NotificationService notificationService = new NotificationService();
    private final AppConfig config = AppConfig.getInstance();

    public void fecharPedido(String cliente, String produto, int quantidade,
                              BigDecimal valorUnitario, DiscountStrategy estrategiaDesconto) {

        System.out.println("===== " + config.get("nomeLoja") + " =====");

        if (!stockService.hasStock(produto, quantidade)) {
            System.out.println("[Pedido] Estoque insuficiente para concluir o pedido.");
            return;
        }
        stockService.reserve(produto, quantidade);

        BigDecimal valorTotal = valorUnitario.multiply(BigDecimal.valueOf(quantidade));
        BigDecimal valorComDesconto = estrategiaDesconto.applyDiscount(valorTotal);

        System.out.printf("[Pedido] Valor original: R$ %.2f | %s | Valor final: R$ %.2f %s%n",
                valorTotal, estrategiaDesconto.getDescricao(), valorComDesconto, config.get("moeda"));

        paymentService.charge(cliente, valorComDesconto);
        notificationService.notifyCustomer(cliente,
                "Seu pedido de " + quantidade + "x \"" + produto + "\" foi confirmado!");

        System.out.println("[Pedido] Concluido com sucesso.\n");
    }
}
