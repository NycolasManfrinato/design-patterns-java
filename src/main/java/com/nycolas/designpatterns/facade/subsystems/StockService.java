package com.nycolas.designpatterns.facade.subsystems;

/** Subsistema: controle simples de estoque. */
public class StockService {

    public boolean hasStock(String produto, int quantidade) {
        System.out.printf("[Estoque] Verificando disponibilidade de %d un. de \"%s\"...%n", quantidade, produto);
        // Regra simplificada apenas para fins didaticos do desafio.
        return quantidade <= 10;
    }

    public void reserve(String produto, int quantidade) {
        System.out.printf("[Estoque] Reservando %d un. de \"%s\".%n", quantidade, produto);
    }
}
