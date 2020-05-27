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
                .learningRate(0.2).build();
        System.out.println("Before training: "+network.toJson());
        for (int i=0; i<100000; ++i) {
            double d = Maths.boundedRandom(0.0, 1.0);
            network.train(Arrays.asList(d), Arrays.asList(0.0));
        }
        System.out.println("After training: "+network.toJson());
        
        List<Double> result = network.evaluate(Arrays.asList(0.5));
        assertEquals(0.0, result.get(0), 0.01);
        result = network.evaluate(Arrays.asList(0.85));
        assertEquals(0.0, result.get(0), 0.01);
        result = network.evaluate(Arrays.asList(0.15));
        assertEquals(0.0, result.get(0), 0.01);
    }

    @Test
    public void testLearnX() throws IOException {
        Network network = new Network.Builder().innerLayerCount(0).inputLayerSize(1).outputLayerSize(1)
                .learningRate(0.2).build();
        System.out.println("Before training: "+network.toJson());
        for (int i=0; i<100000; ++i) {
            double d = Maths.boundedRandom(0.0, 1.0);
            network.train(Arrays.asList(d), Arrays.asList(d));
        }
        System.out.println("After training: "+network.toJson());
        
        List<Double> result = network.evaluate(Arrays.asList(0.5));
        assertEquals(0.5, result.get(0), 0.01);
        result = network.evaluate(Arrays.asList(0.85));
        assertEquals(0.85, result.get(0), 0.01);
        result = network.evaluate(Arrays.asList(0.15));
        assertEquals(0.15, result.get(0), 0.01);
    }

    public void testLearnNegativeX() throws IOException {
        Network network = new Network.Builder().innerLayerCount(0).innerLayerSize(0).inputLayerSize(1).outputLayerSize(1)
                .learningRate(0.2).build();
        System.out.println("Before training: "+network.toJson());
        for (double d=0; d<8.0; ++d) {
            network.train(Arrays.asList(d), Arrays.asList(-d));
        }
        System.out.println("After training: "+network.toJson());
        List<Double> result = network.evaluate(Arrays.asList(1.5));
        assertEquals(-1.5, result.get(0), 0.001);
    }

    public void testLearnZero_OneInnerLayer() throws IOException {
        System.out.println("STARTSTARTSTART");
        Network network = new Network.Builder().innerLayerCount(1).innerLayerSize(1).inputLayerSize(1).outputLayerSize(1)
                .learningRate(0.1).build();
        System.out.println("Before training: "+network.toJson());
        for (double d=-8.0; d<32.0; ++d) {
            network.train(Arrays.asList(d), Arrays.asList(0.0));
            System.out.println("After training: "+network.toJson());
        }
        List<Double> result = network.evaluate(Arrays.asList(1.5));
        System.out.println("ENDENDEND");
        assertEquals(0.0, result.get(0), 0.001);
    }

    public void testXor() {
        var network = new Network.Builder().learningRate(0.2).inputLayerSize(2).innerLayerSize(3).outputLayerSize(1)
                .innerLayerCount(2).build();

    }
}