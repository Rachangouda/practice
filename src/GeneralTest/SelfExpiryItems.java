package GeneralTest;

import org.apache.commons.collections4.map.PassiveExpiringMap;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class SelfExpiryItems {

    public static void main(String[] args) {


        PassiveExpiringMap.ConstantTimeToLiveExpirationPolicy<String, Integer>
                expirePeriod = new PassiveExpiringMap.ConstantTimeToLiveExpirationPolicy<>(
                30, TimeUnit.SECONDS);
        PassiveExpiringMap map = new PassiveExpiringMap<>(expirePeriod, new HashMap<>());


        map.put("ssds", 213);
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.format("value:%d", map.get("ssds"));

    }
}
