package com.edwingustafson.primetime;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class PrimeTimeTest {
    final int[] ns = new int[2_000_000];
    final Random random = new Random();

    @Before
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