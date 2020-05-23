package com.bitsforabetterworld.learningnn;

import java.security.SecureRandom;

public class Maths {
    private static final SecureRandom rand = new SecureRandom();

    // Logistic function. Returns a value in the range (0, 1)
    public static double sigmoid(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    public static double random() {
        return rand.nextDouble();
    }
}