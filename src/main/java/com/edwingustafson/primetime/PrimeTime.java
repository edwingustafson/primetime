package com.edwingustafson.primetime;

import java.util.stream.IntStream;

public class PrimeTime {
    public static boolean prime(final int n) {
        return IntStream.range(2, n).filter(m -> m * m < n).noneMatch(m -> n % m == 0);
    }
}
