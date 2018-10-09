package com.edwingustafson.primetime;

public class PrimeTime {
    public static boolean prime(final int n) {
        for( int m = 2; m * m <= n; m++ ) {
            if( n % m == 0 ) return false;
        }

        return true;
    }
}
