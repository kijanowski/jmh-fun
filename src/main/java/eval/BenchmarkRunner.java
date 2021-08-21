package eval;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        var options = new OptionsBuilder()
            .include(SetVsList.class.getSimpleName())
            .forks(1)
            .build();
        new Runner(options).run();
    }
}