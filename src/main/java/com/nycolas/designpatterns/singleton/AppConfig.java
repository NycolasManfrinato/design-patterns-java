package com.nycolas.designpatterns.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Padrao Singleton.
 *
 * Garante que exista uma unica instancia de configuracao compartilhada
 * por toda a aplicacao, evitando leituras/gravacoes concorrentes de
 * multiplas copias de configuracao e centralizando o acesso a ela.
 *
 * A criacao da instancia e feita de forma "lazy" (somente quando
 * necessaria) e thread-safe atraves do bloco "synchronized".
 */
public final class AppConfig {

    private static AppConfig instance;

    private final Map<String, String> settings = new HashMap<>();

    private AppConfig() {
        // valores padrao da aplicacao
        settings.put("nomeLoja", "DIO Store");
        settings.put("moeda", "BRL");
        settings.put("percentualDescontoMaximo", "30");
    }

    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String get(String chave) {
        return settings.get(chave);
    }

    public void set(String chave, String valor) {
        settings.put(chave, valor);
    }
}
