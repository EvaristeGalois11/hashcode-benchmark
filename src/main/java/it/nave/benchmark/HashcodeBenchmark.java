package it.nave.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.util.HashMap;
import java.util.Map;

@Fork(value = 5)
@Warmup(iterations = 3)
@BenchmarkMode(Mode.SingleShotTime)
public class HashcodeBenchmark {
    private static final int NUMBER_OF_ELEMENTS = 100_000_000;
    private static final String CONSTANT_VALUE = "Nel mezzo del cammin di nostra vita, mi ritrovai per una selva oscura";

    @Benchmark
    public void longKeys(Blackhole blackhole) {
        Map<Long, String> map = HashMap.newHashMap(NUMBER_OF_ELEMENTS);
        for (long i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            map.put(i, CONSTANT_VALUE);
        }
        blackhole.consume(map);
    }

    @Benchmark
    public void integerKeys(Blackhole blackhole) {
        Map<Integer, String> map = HashMap.newHashMap(NUMBER_OF_ELEMENTS);
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            map.put(i, CONSTANT_VALUE);
        }
        blackhole.consume(map);
    }
}
