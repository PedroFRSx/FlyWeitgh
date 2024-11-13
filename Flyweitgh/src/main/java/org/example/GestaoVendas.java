package org.example;

import java.util.ArrayList;
import java.util.List;

public class GestaoVendas {

    private List<Celular> celulares = new ArrayList<>();

    // Método para adicionar um celular à venda
    public void adicionarCelular(String numeroSerie, String cor, String marca, String modelo, double preco) {
        CelularFlyweight flyweight = CelularFactory.getFlyweight(marca, modelo, preco);  // Obtém ou cria o Flyweight
        Celular celular = new Celular(numeroSerie, cor, flyweight);  // Cria um celular com dados variáveis
        celulares.add(celular);
    }

    // Método para listar todos os celulares
    public List<String> listarCelulares() {
        List<String> lista = new ArrayList<>();
        for (Celular celular : celulares) {
            lista.add(celular.toString());
        }
        return lista;
    }

    // Método para obter o total de diferentes combinações de marca/modelo
    public int getTotalModelos() {
        return CelularFactory.getTotalFlyweights();
    }
}