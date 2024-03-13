package uvg.edu.gt;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * La clase CardCollectionManager gestiona la colección de cartas y proporciona métodos para cargar, agregar y mostrar cartas.
 */
public class CardCollectionManager {
    private Map<String, String> allCards;
    private Map<String, Integer> userCollection;

    /**
     * Constructor de la clase CardCollectionManager.
     * @param mapFactory El factory utilizado para crear la implementación de Map.
     */
    public CardCollectionManager(MapFactory mapFactory) {
        this.allCards = mapFactory.createMap();
        this.userCollection = new HashMap<>();
    }

    /**
     * Carga las cartas desde un archivo y las añade al conjunto de cartas disponibles.
     * @param filename El nombre del archivo que contiene la información de las cartas.
     */
    public void loadCardsFromFile(String filename) {
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    allCards.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Agrega una carta a la colección del usuario.
     * @param cardName El nombre de la carta que se desea agregar.
     */
    public void addCardToUserCollection(String cardName) {
        if (allCards.containsKey(cardName)) {
            userCollection.put(cardName, userCollection.getOrDefault(cardName, 0) + 1);
            System.out.println("Carta agregada a la colección: " + cardName);
        } else {
            System.out.println("Error: La carta no está disponible.");
        }
    }

    /**
     * Muestra el tipo de una carta específica.
     * @param cardName El nombre de la carta de la cual se desea mostrar el tipo.
     */
    public void showCardType(String cardName) {
        if (allCards.containsKey(cardName)) {
            System.out.println("Tipo de carta: " + allCards.get(cardName));
        } else {
            System.out.println("Error: La carta no está disponible.");
        }
    }

    /**
     * Muestra las cartas en la colección del usuario.
     */
    public void showUserCollection() {
        System.out.println("Cartas en la colección del usuario:");
        for (Map.Entry<String, Integer> entry : userCollection.entrySet()) {
            System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + allCards.get(entry.getKey()) + ", Cantidad: " + entry.getValue());
        }
    }

    /**
     * Muestra las cartas en la colección del usuario, ordenadas por tipo.
     */
    public void showUserCollectionByType() {
        System.out.println("Cartas en la colección del usuario, ordenadas por tipo:");
        Map<String, List<String>> cardsByType = new HashMap<>();
        for (Map.Entry<String, Integer> entry : userCollection.entrySet()) {
            String cardName = entry.getKey();
            String cardType = allCards.get(cardName);
            cardsByType.computeIfAbsent(cardType, k -> new ArrayList<>()).add(cardName);
        }

        for (Map.Entry<String, List<String>> entry : cardsByType.entrySet()) {
            String cardType = entry.getKey();
            List<String> cardNames = entry.getValue();
            System.out.println("Tipo: " + cardType + ", Cartas: " + String.join(", ", cardNames));
        }
    }

    /**
     * Muestra todas las cartas disponibles.
     *
     * @return
     */
    public ArrayList showAllCards() {
        System.out.println("Todas las cartas disponibles:");
        for (Map.Entry<String, String> entry : allCards.entrySet()) {
            System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue());
        }

        return null;
    }

    /**
     * Muestra todas las cartas disponibles, ordenadas por tipo.
     */
    public void showAllCardsByType() {
        System.out.println("Todas las cartas disponibles, ordenadas por tipo:");
        Map<String, List<String>> cardsByType = new HashMap<>();
        for (Map.Entry<String, String> entry : allCards.entrySet()) {
            String cardName = entry.getKey();
            String cardType = entry.getValue();
            cardsByType.computeIfAbsent(cardType, k -> new ArrayList<>()).add(cardName);
        }

        for (Map.Entry<String, List<String>> entry : cardsByType.entrySet()) {
            String cardType = entry.getKey();
            List<String> cardNames = entry.getValue();
            System.out.println("Tipo: " + cardType + ", Cartas: " + String.join(", ", cardNames));
        }
    }
}
