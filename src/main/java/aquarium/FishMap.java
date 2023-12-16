package aquarium;

import java.util.HashMap;
import java.util.Map;

public class FishMap {
    public static Map<String, Class<? extends Fish>> getMap() {
        Map<String, Class<? extends Fish>> map = new HashMap<>();
        map.put("Grey", FishGrey.class);
        map.put("Orange", FishOrange.class);
        map.put("Prawn", FishPrawn.class);
        map.put("Green", FishGreen.class);

        return map;
    }
}
