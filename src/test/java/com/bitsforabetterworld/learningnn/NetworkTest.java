package com.bitsforabetterworld.learningnn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class NetworkTest {

    @Test
    public void testLearnZero() throws IOException {
        Network network = new Network.Builder().innerLayerCount(0).inputLayerSize(1).outputLayerSize(1)
                .learningRate(1.0).build();
        System.out.println("Before training: "+network.toJson());
        network.train(Arrays.asList(1.0), Arrays.asList(0.0));
        System.out.println("After training: "+network.toJson());
        List<Double> result = network.evaluate(Arrays.asList(1.5));
        assertEquals(0.0, result.get(0), 0.001);
    }

    @Test
    public void testLearnX() throws IOException {
        Network network = new Network.Builder().innerLayerCount(0).innerLayerSize(0).inputLayerSize(1).outputLayerSize(1)
                .learningRate(0.2).build();
        System.out.println("Before training: "+network.toJson());
        for (double d=0; d<8.0; ++d) {
            network.train(Arrays.asList(d), Arrays.asList(d));
        }
        System.out.println("After training: "+network.toJson());
        List<Double> result = network.evaluate(Arrays.asList(1.5));
        assertEquals(1.5, result.get(0), 0.001);
    }

    public void testXor() {
        var network = new Network.Builder().learningRate(0.2).inputLayerSize(2).innerLayerSize(3).outputLayerSize(1)
                .innerLayerCount(2).build();
        int count = 0;
        int maxCount = 1;
        for (double sumOfSquareError = Double.MAX_VALUE; count < maxCount && sumOfSquareError > 0.1; ++count) {
            sumOfSquareError = 0.0;
            double err = network.train(Arrays.asList(0.0, 0.0), Arrays.asList(0.0));
            sumOfSquareError += (err * err);
            err = network.train(Arrays.asList(0.0, 1.0), Arrays.asList(1.0));
            sumOfSquareError += (err * err);
            err = network.train(Arrays.asList(1.0, 0.0), Arrays.asList(1.0));
            sumOfSquareError += (err * err);
            err = network.train(Arrays.asList(1.0, 1.0), Arrays.asList(0.0));
            sumOfSquareError += (err * err);
            System.out.println("Iteration[" + count + "] = " + sumOfSquareError);
        }
        var result00 = network.evaluate(Arrays.asList(0.0, 0.0));
        var result01 = network.evaluate(Arrays.asList(0.0, 1.0));
        var result10 = network.evaluate(Arrays.asList(1.0, 0.0));
        var result11 = network.evaluate(Arrays.asList(1.0, 1.0));
        assertEquals("hehlo", Arrays.asList(result00, result01, result10, result11));

    }
}