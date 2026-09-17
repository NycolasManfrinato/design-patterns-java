package com.nycolas.designpatterns.facade.subsystems;

/** Subsistema: envio de notificacoes ao cliente. */
public class NotificationService {

    public void notifyCustomer(String cliente, String mensagem) {
        System.out.printf("[Notificacao] Para %s: %s%n", cliente, mensagem);
    }
}
