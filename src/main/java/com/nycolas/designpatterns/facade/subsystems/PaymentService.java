package com.nycolas.designpatterns.facade.subsystems;

import java.math.BigDecimal;

/** Subsistema: processamento de pagamento. */
public class PaymentService {

    public void charge(String cliente, BigDecimal valor) {
        System.out.printf("[Pagamento] Cobrando R$ %.2f de %s.%n", valor, cliente);
    }
}
