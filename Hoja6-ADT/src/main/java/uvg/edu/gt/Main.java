package uvg.edu.gt;

import java.util.Scanner;

/**
 * La clase Main es la clase principal que inicia el programa y gestiona la interacción con el usuario.
 */
public class Main {
    /**
     * El método principal que inicia el programa.
     * @param args Los argumentos de línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        MapFactory mapFactory = getMapFactoryFromUserInput();
        CardCollectionManager cartaManager = new CardCollectionManager(mapFactory);
        cartaManager.loadCardsFromFile("cards_desc.txt");

        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner, cartaManager);

        // Mostrar el menú principal
        menu.mostrarMenu();
    }

    /**
     * Método que solicita al usuario que seleccione la implementación de Map a utilizar.
     * @return La implementación de Map seleccionada por el usuario.
     * @throws IllegalArgumentException Si el usuario ingresa una opción inválida.
     */
    private static MapFactory getMapFactoryFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la implementación de Map:");
        System.out.println("1) HashMap");
        System.out.println("2) TreeMap");
        System.out.println("3) LinkedHashMap");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return new HashMapFactory();
            case 2:
                return new TreeMapFactory();
            case 3:
                return new LinkedHashMapFactory();
            default:
                throw new IllegalArgumentException("Opción no válida.");
        }
    }
}
