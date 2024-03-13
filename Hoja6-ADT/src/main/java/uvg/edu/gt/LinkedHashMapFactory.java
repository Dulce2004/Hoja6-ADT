package uvg.edu.gt;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * La clase LinkedHashMapFactory implementa la interfaz MapFactory para crear instancias de LinkedHashMap.
 */
public class LinkedHashMapFactory implements MapFactory {
    /**
     * Crea y devuelve una nueva instancia de LinkedHashMap.
     * @return Una nueva instancia de LinkedHashMap.
     */
    @Override
    public Map<String, String> createMap() {
        return new LinkedHashMap<>();
    }
}
