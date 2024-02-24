package com.edwingustafson.primetime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

@DisplayName("PrimeTime")
public class PrimeTimeTest {
	final int[] ns = new int[1_000_000];
	final Random random = new Random();

	@BeforeEach
	public void setUp() throws Exception {
		Arrays.setAll(ns, (i) -> 2 + random.nextInt(9998));
	}

	@Test
	@DisplayName("Serial loop")
	public void loop() {
		for (int i = 0; i < ns.length; i++)
			PrimeTime.prime(ns[i]);
	}

	@Test
	@DisplayName("Serial iterator")
	public void iterator() {
		for (int n: ns)
			PrimeTime.prime(n);
	}

	@Test
	@DisplayName("Serial stream")
	public void functional() {
		Arrays.stream(ns).forEach(PrimeTime::prime);
	}

	@Test()
	@DisplayName("Parallel stream")
	public void parallel() {
		Arrays.stream(ns).parallel().forEach(PrimeTime::prime);
	}
}
