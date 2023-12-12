package aquarium;

import java.util.HashMap;
import java.util.Map;

public class FishMap {
    public static Map<String, Class<? extends Fish>> getMap() {
        Map<String, Class<? extends Fish>> map = new HashMap<>();
        map.put("Grey", GreyFish.class);
        map.put("Orange", OrangeFish.class);

        return map;
    }
}
