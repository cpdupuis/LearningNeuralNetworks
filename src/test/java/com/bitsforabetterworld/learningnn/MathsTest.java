package com.bitsforabetterworld.learningnn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathsTest {
    @Test
    public void testSigmoidZero() {
        assertEquals(0.5, Maths.sigmoid(0.0));
    }

    @Test
    public void testSigmoidMax() {
        assertEquals(1.0, Maths.sigmoid(Double.POSITIVE_INFINITY));
    }

    @Test
    public void testSigmoidMin() {
        assertEquals(0.0, Maths.sigmoid(Double.NEGATIVE_INFINITY));
    }
    
    @Test
    public void testSigmoidPrimeZero() {
        assertEquals(0.25, Maths.sigmoidPrime(0.0));
    }

    @Test
    public void testSigmoidPrimePositive() {
        assertEquals(4.54e-5, Maths.sigmoidPrime(10.0), 1e-6);
    }

    @Test
    public void testSigmoidPrimeNegative() {
        assertEquals(4.54e-5, Maths.sigmoidPrime(-10.0), 1e-6);
    }
}
