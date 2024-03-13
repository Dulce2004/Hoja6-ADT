package uvg.edu.gt;

import java.util.HashMap;
import java.util.Map;

/**
 * La clase HashMapFactory implementa la interfaz MapFactory para crear instancias de HashMap.
 */
class HashMapFactory implements MapFactory {
    /**
     * Crea y devuelve una nueva instancia de HashMap.
     * @return Una nueva instancia de HashMap.
     */
    @Override
    public Map<String, String> createMap() {
        return new HashMap<>();
    }
}
