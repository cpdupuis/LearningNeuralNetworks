package com.bitsforabetterworld.learningnn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

public class NetworkTest {
    @Test
    public void testRandoms() {

    }    

    public void testXor() {
        var network = new Network.Builder()
        .learningRate(0.2)
        .inputLayerSize(2)
        .innerLayerSize(3)
        .outputLayerSize(1)
        .innerLayerCount(2)
        .build();
        int count = 0;
        int maxCount = 1;
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
        var result00 = network.evaluate(Arrays.asList(0.0, 0.0));
        var result01 = network.evaluate(Arrays.asList(0.0, 1.0));
        var result10 = network.evaluate(Arrays.asList(1.0, 0.0));
        var result11 = network.evaluate(Arrays.asList(1.0, 1.0));
        assertEquals("hehlo", Arrays.asList(result00, result01, result10, result11));

    }
}