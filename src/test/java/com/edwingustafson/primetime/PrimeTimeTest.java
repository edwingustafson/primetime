package com.edwingustafson.primetime;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class PrimeTimeTest {
    final int[] ns = new int[1_500_000];

    @Before
    public void setUp() throws Exception {
        final Random random = new Random();

        for(int i = 0; i < ns.length; i++) ns[i] = random.nextInt();
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