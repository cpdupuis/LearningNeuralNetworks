package com.bitsforabetterworld.learningnn;

import java.security.SecureRandom;

public class Maths {
    private static final SecureRandom rand = new SecureRandom();

    public static double activationFunction(double x) {
        return Math.tanh(x);
    }
    
    public static double derivativeActivationFunction(double x) {
        double coshx = Math.cosh(x);
        return 1 / (coshx * coshx);
    }

    // Logistic function. Returns a value in the range (0, 1)
    public static double sigmoid(double x) {
        return 1.0 / (1.0 + Math.exp(-x));

    }

    public static double randomWeight() {
        return boundedRandom(-1.0, 1.0);
    }

    public static double boundedRandom(double min, double max) {
        double d = rand.nextDouble();
        d = d * (max - min) + min;
        return d;
    }
}