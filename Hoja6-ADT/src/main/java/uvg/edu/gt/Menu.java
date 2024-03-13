package uvg.edu.gt;

import java.util.Scanner;

/**
 * La clase Menu proporciona un menú de opciones para que el usuario interactúe con el CardCollectionManager.
 */
public class Menu {
    private Scanner scanner;
    private CardCollectionManager cartaManager;

    /**
     * Constructor de la clase Menu.
     * @param scanner El objeto Scanner utilizado para la entrada del usuario.
     * @param cartaManager El objeto CardCollectionManager que gestiona las operaciones con las cartas.
     */
    public Menu(Scanner scanner, CardCollectionManager cartaManager) {
        this.scanner = scanner;
        this.cartaManager = cartaManager;
    }

    /**
     * Muestra el menú de opciones y permite al usuario interactuar con el CardCollectionManager.
     */
    public void mostrarMenu() {
        while (true) {
            // Menú de opciones
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar carta a la colección");
            System.out.println("2. Mostrar tipo de una carta");
            System.out.println("3. Mostrar todas las cartas en la colección");
            System.out.println("4. Mostrar todas tus cartas ordenadas por tipo");
            System.out.println("5. Mostrar todas las cartas disponibles");
            System.out.println("6. Mostrar todas las cartas disponibles ordenadas por tipo");
            System.out.println("7. Salir");
            System.out.print("Ingrese su opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la carta que desea agregar: ");
                    String nombreCarta = scanner.nextLine();
                    cartaManager.addCardToUserCollection(nombreCarta);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la carta: ");
                    String nombreCartaAMostrar = scanner.nextLine();
                    cartaManager.showCardType(nombreCartaAMostrar);
                    break;
                case 3:
                    cartaManager.showUserCollection();
                    break;
                case 4:
                    cartaManager.showUserCollectionByType();
                    break;
                case 5:
                    cartaManager.showAllCards();
                    break;
                case 6:
                    cartaManager.showAllCardsByType();
                    break;
                case 7:
                    System.out.println("¡Adiós!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
}
