package uvg.edu.gt;

import java.util.Map;
import java.util.TreeMap;

/**
 * La clase TreeMapFactory implementa la interfaz MapFactory para crear instancias de TreeMap.
 */
public class TreeMapFactory implements MapFactory {
    /**
     * Crea y devuelve una nueva instancia de TreeMap.
     * @return Una nueva instancia de TreeMap.
     */
    @Override
    public Map<String, String> createMap() {
        return new TreeMap<>();
    }
}
