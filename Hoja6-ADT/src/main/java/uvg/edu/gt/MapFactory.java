package uvg.edu.gt;

import java.util.Map;

/**
 * La interfaz MapFactory define un método para crear un objeto de tipo Map.
 */
public interface MapFactory {
    /**
     * Método para crear un objeto de tipo Map.
     * @return Un objeto de tipo Map.
     */
    Map<String, String> createMap();
}
