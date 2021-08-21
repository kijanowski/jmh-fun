package eval;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 2)
public class SetVsList {
        private static final String NEAR_PIN = "01234";
        private static final String FAR_PIN = "43210";

    @State(Scope.Thread)
    public static class MyState {
        private final List<String> forbiddenPinsList = List.of(
            NEAR_PIN, "12345", "23456", "34567", "45678", "56789",
            "98765", "87654", "76543", "65432", "54321", FAR_PIN
        );
        private final Set<String> forbiddenPinsSet = Set.of(
            NEAR_PIN, "12345", "23456", "34567", "45678", "56789",
            "98765", "87654", "76543", "65432", "54321", FAR_PIN
        );
    }

    @Benchmark
    public int testHashCode() {
        return "13568".hashCode();
    }

    @Benchmark
    public boolean testSetWithNearPin(MyState state) {
        return state.forbiddenPinsSet.contains(NEAR_PIN);
    }

    @Benchmark
    public boolean testSetWithFarPin(MyState state) {
        return state.forbiddenPinsSet.contains(FAR_PIN);
    }

    @Benchmark
    public boolean testListWithNearPin(MyState state) {
        return state.forbiddenPinsList.contains(NEAR_PIN);
    }

    @Benchmark
    public boolean testListWithFarPin(MyState state) {
        return state.forbiddenPinsList.contains(FAR_PIN);
    }

}
