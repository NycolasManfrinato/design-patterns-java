package com.nycolas.designpatterns;

import com.nycolas.designpatterns.singleton.AppConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class AppConfigTest {

    @Test
    void getInstanceSempreRetornaAMesmaInstancia() {
        AppConfig primeira = AppConfig.getInstance();
        AppConfig segunda = AppConfig.getInstance();
        assertSame(primeira, segunda);
    }

    @Test
    void alteracaoEmUmaReferenciaReflitaNaOutra() {
        AppConfig config = AppConfig.getInstance();
        config.set("moeda", "USD");
        assertEquals("USD", AppConfig.getInstance().get("moeda"));
        config.set("moeda", "BRL"); // restaura o padrao para nao afetar outros testes
    }
}
