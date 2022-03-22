package com.edwingustafson.primetime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class PrimeTimeTest {
    final int[] ns = new int[2_097_152];
    final Random random = new Random();

    @BeforeEach
    public void setUp() throws Exception {
        Arrays.setAll(ns, (i) -> 2 + random.nextInt(9998));
    }

    @Test
    public void imperative() {
        for(int i = 0; i < ns.length; i++) PrimeTime.prime(ns[i]);
    }

    @Test
    public void functional() {
        Arrays.stream(ns).forEach(PrimeTime::prime);
    }

    @Test
    public void parallel() {
        Arrays.stream(ns).parallel().forEach(PrimeTime::prime);
    }
}