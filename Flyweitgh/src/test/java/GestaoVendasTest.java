import org.example.GestaoVendas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

// Classe de Teste para a Gestão de Vendas e Celulares
class GestaoVendasTest {

    private GestaoVendas gestaoVendas;

    @BeforeEach
    void setUp() {
        // Inicializa a instância da gestão de vendas antes de cada teste
        gestaoVendas = new GestaoVendas();
    }

    // Testando se celulares com a mesma marca e modelo compartilham o Flyweight
    @Test
    void testCelularesComMesmaMarcaEModeloCompartilhamFlyweight() {
        // Adicionando dois celulares com a mesma marca e modelo
        gestaoVendas.adicionarCelular("12345", "Preto", "Apple", "iPhone 13", 7000.0);
        gestaoVendas.adicionarCelular("67890", "Branco", "Apple", "iPhone 13", 7000.0);

        // Obtendo os celulares e seus Flyweights
        List<String> celulares = gestaoVendas.listarCelulares();

        // Verificando que temos dois celulares, mas o Flyweight é compartilhado
        assertEquals(2, celulares.size());
        String celular1 = celulares.get(0);
        String celular2 = celulares.get(1);

        // Verificando se os dados de marca, modelo e preço são iguais
        assertTrue(celular1.contains("Apple"));
        assertTrue(celular1.contains("iPhone 13"));
        assertTrue(celular1.contains("7000.0"));

        // Verificando que o Flyweight é o mesmo
        assertTrue(celular1.contains(celular2.substring(celular2.indexOf("Apple"))));
    }

    // Testando celulares com marcas ou modelos diferentes geram Flyweights distintos
    @Test
    void testCelularesComMarcasOuModelosDiferentesGeramFlyweightsDistintos() {
        // Adicionando celulares com diferentes marcas ou modelos
        gestaoVendas.adicionarCelular("12345", "Preto", "Apple", "iPhone 13", 7000.0);
        gestaoVendas.adicionarCelular("67890", "Branco", "Samsung", "Galaxy S22", 5000.0);
        gestaoVendas.adicionarCelular("11223", "Azul", "Samsung", "Galaxy S21", 4500.0);

        // Obtendo a lista de celulares
        List<String> celulares = gestaoVendas.listarCelulares();

        // Verificando se o número de Flyweights aumentou
        assertEquals(3, celulares.size());
        assertEquals(3, gestaoVendas.getTotalModelos());  // Deveriam ser 3 modelos distintos
    }

    // Testando o número total de modelos diferentes
    @Test
    void testTotalModelosDiferentes() {
        // Adicionando celulares com diferentes modelos e marcas
        gestaoVendas.adicionarCelular("12345", "Preto", "Apple", "iPhone 13", 7000.0);
        gestaoVendas.adicionarCelular("67890", "Branco", "Samsung", "Galaxy S22", 5000.0);
        gestaoVendas.adicionarCelular("11223", "Azul", "Samsung", "Galaxy S21", 4500.0);

        // Verificando o número de modelos distintos
        assertEquals(3, gestaoVendas.getTotalModelos());
    }

    // Testando se o Flyweight não é recriado para a mesma combinação de marca e modelo
    @Test
    void testFlyweightNaoRecriadoParaMesmaCombinacaoMarcaModelo() {
        // Adicionando celulares com a mesma marca e modelo
        gestaoVendas.adicionarCelular("12345", "Preto", "Apple", "iPhone 13", 7000.0);
        gestaoVendas.adicionarCelular("67890", "Branco", "Apple", "iPhone 13", 7000.0);

        // Obtendo o número total de Flyweights
        int totalFlyweightsAntes = gestaoVendas.getTotalModelos();

        // Adicionando mais celulares com a mesma marca e modelo
        gestaoVendas.adicionarCelular("11111", "Dourado", "Apple", "iPhone 13", 7000.0);
        gestaoVendas.adicionarCelular("22222", "Azul", "Apple", "iPhone 13", 7000.0);

        // Verificando se o número de Flyweights não aumentou
        assertEquals(totalFlyweightsAntes, gestaoVendas.getTotalModelos());
    }

    // Testando a lista de celulares e suas informações detalhadas
    @Test
    void testListarCelulares() {
        // Adicionando celulares
        gestaoVendas.adicionarCelular("12345", "Preto", "Apple", "iPhone 13", 7000.0);
        gestaoVendas.adicionarCelular("67890", "Branco", "Apple", "iPhone 13", 7000.0);
        gestaoVendas.adicionarCelular("11223", "Azul", "Samsung", "Galaxy S21", 4500.0);

        // Obtendo e verificando a lista de celulares
        List<String> celulares = gestaoVendas.listarCelulares();

        // Verificando que a lista contém os celulares corretamente
        assertEquals(3, celulares.size());
        assertTrue(celulares.get(0).contains("Apple"));
        assertTrue(celulares.get(1).contains("iPhone 13"));
        assertTrue(celulares.get(2).contains("Samsung"));
    }
}
