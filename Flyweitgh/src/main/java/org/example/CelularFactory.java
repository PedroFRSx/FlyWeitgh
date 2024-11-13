package org.example;

import java.util.HashMap;
import java.util.Map;

public class CelularFactory {
    // Mapa para armazenar as instâncias compartilhadas de CelularFlyweight
    private static Map<String, CelularFlyweight> flyweights = new HashMap<>();

    // Método para obter ou criar uma instância de CelularFlyweight
    public static CelularFlyweight getFlyweight(String marca, String modelo, double preco) {
        // Cria uma chave única para a combinação de marca e modelo
        String key = marca + modelo;

        // Verifica se já existe uma instância de CelularFlyweight para essa chave
        if (!flyweights.containsKey(key)) {
            // Se não existe, cria uma nova instância e armazena no mapa
            flyweights.put(key, new CelularFlyweight(marca, modelo, preco));
        }

        // Retorna a instância compartilhada de CelularFlyweight
        return flyweights.get(key);
    }

    // Método para obter o número total de diferentes combinações de marca/modelo
    public static int getTotalFlyweights() {
        return flyweights.size();  // Retorna o número de chaves (diferentes combinações marca/modelo)
    }
}
