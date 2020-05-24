package com.bitsforabetterworld.learningnn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

public class NetworkTest {
    @Test
    public void testXor() {
        var network = new Network(0.2, 2, 8, 1, 2);
        int count = 0;
        int maxCount = 100;
        for (double sumOfSquareError = Double.MAX_VALUE; count < maxCount && sumOfSquareError > 0.1;++count) {
            sumOfSquareError = 0.0;
            double err = network.train(Arrays.asList(0.0, 0.0), Arrays.asList(0.0));
            sumOfSquareError += (err * err);
            err = network.train(Arrays.asList(0.0, 1.0), Arrays.asList(1.0));
            sumOfSquareError += (err * err);
            err =  network.train(Arrays.asList(1.0, 0.0), Arrays.asList(1.0));
            sumOfSquareError += (err * err);
            err =  network.train(Arrays.asList(1.0, 1.0), Arrays.asList(0.0));
            sumOfSquareError += (err * err);
            System.out.println("Iteration["+count+"] = "+sumOfSquareError);
        }
        var result = network.evaluate(Arrays.asList(0.0, 0.0));
        assertEquals(1, result.size());
        assertEquals(0.0, result.get(0), 0.01);

        result = network.evaluate(Arrays.asList(0.0, 1.0));
        assertEquals(1.0, result.get(0), 0.01);

        result = network.evaluate(Arrays.asList(1.0, 0.0));
        assertEquals(1.0, result.get(0), 0.01);

        result = network.evaluate(Arrays.asList(1.0, 1.0));
        assertEquals(0.0, result.get(0), 0.01);

    }
}