package com.paswolf.benchmark;

import org.openjdk.jmh.annotations.*;

/**
 * @author Wolfram Huesken
 */
public class StartsWithBenchmark {

    @State(Scope.Benchmark)
    public static class Keys {
        String key1 = "MY_product_NA146AC50OCBSG_en";
    }

    @Benchmark
    public void testReferenceStartsWith(Keys keys) {
        boolean isProduct = keys.key1.startsWith("MY_product_");
    }

    @Benchmark
    public void testReferenceIndexOf(Keys keys) {
        boolean isProduct = keys.key1.indexOf("MY_product_") == 0;
    }

    @Benchmark
    public void testDoubleIndexOf(Keys keys) {
        boolean isProduct = keys.key1.indexOf("MY_product_") == 0 && keys.key1.indexOf("MY_product_index") != -1;
    }

    @Benchmark
    public void testIndexOfAndContains(Keys keys) {
        boolean isProduct = keys.key1.indexOf("MY_product_") == 0 && !keys.key1.contains("MY_product_index");
    }

    @Benchmark
    public void testIndexOfAndUppercase(Keys keys) {
        boolean isProduct = keys.key1.indexOf("MY_product_") == 0 &&
            (keys.key1.charAt(11) >= 65 && keys.key1.charAt(11) <= 90);
    }

    @Benchmark
    public void testStartsWithAndUppercase(Keys keys) {
        boolean isProduct = keys.key1.startsWith("MY_product_") &&
            (keys.key1.charAt(11) >= 65 && keys.key1.charAt(11) <= 90);
    }

}
