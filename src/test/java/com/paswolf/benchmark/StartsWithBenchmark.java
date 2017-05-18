package com.paswolf.benchmark;

import org.openjdk.jmh.annotations.*;

/**
 * @author Wolfram Huesken
 */
public class StartsWithBenchmark {

    @State(Scope.Benchmark)
    public static class Keys {
        String key1 = "MY_productSuperCoolProduct";
        String key2 = "alohaMY_productSuperCoolProduct";
        String key3 = "MY_productSuperCoolProductaloha";
    }

    @Benchmark
    public void testStartsWith(Keys keys) {
        keys.key1.startsWith("aloha");
        keys.key2.startsWith("aloha");
    }

    @Benchmark
    public void testEndsWith(Keys keys) {
        keys.key2.startsWith("aloha");
        keys.key3.startsWith("aloha");
    }

    @Benchmark
    public void testIndexOf(Keys keys) {
        keys.key1.indexOf("aloha");
        keys.key2.indexOf("aloha");
    }

}
