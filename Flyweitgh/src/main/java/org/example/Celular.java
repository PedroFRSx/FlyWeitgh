package org.example;

public class Celular {
    private String numeroSerie;
    private String cor;
    private CelularFlyweight flyweight;  // Referência para a parte compartilhada (marca, modelo, preço)

    public Celular(String numeroSerie, String cor, CelularFlyweight flyweight) {
        this.numeroSerie = numeroSerie;
        this.cor = cor;
        this.flyweight = flyweight;
    }

    // Métodos getter
    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getCor() {
        return cor;
    }

    public CelularFlyweight getFlyweight() {
        return flyweight;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "Número de Série='" + numeroSerie + '\'' +
                ", Cor='" + cor + '\'' +
                ", " + flyweight +  // Exibe as informações compartilhadas
                '}';
    }
}