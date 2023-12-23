package aquarium;

import java.util.Map;

public class FishFactory {
    public static Fish createFish(String fishType) {
        Map<String, Class<? extends Fish>> map = FishMap.getMap();
        Class<? extends Fish> fishClass = map.get(fishType);
        if (fishClass != null) {
            try {
                return fishClass.getDeclaredConstructor().newInstance();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
