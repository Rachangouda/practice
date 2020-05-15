package GeneralTest;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class EnumMapTest {

    public enum Phase {
        SOLID, LIQUID, GAS, PLASMA;

        public enum Transition {
            MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
            BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
            SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);
            // Initialize the phase transition map
            private static final Map<Phase, Map<Phase, Transition>>
                    m = Stream.of(values()).collect(groupingBy(t -> t.from,
                    () -> new EnumMap<>(Phase.class),
                    toMap(t -> t.to, t -> t,
                            (x, y) -> x, () -> new EnumMap<>(Phase.class))));
            private final Phase from;
            private final Phase to;

            Transition(Phase from, Phase to) {
                this.from = from;
                this.to = to;
            }

            public static Transition from(Phase from, Phase to) {
                return m.get(from).get(to);
            }
        }
    }


    public static void main(String[] args) {

        System.out.println("trans: "+Phase.Transition.from(Phase.SOLID,Phase.LIQUID));
    }
}
