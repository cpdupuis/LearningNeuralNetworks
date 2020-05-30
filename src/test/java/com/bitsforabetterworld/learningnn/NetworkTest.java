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
        for (int i = 0; i < 100000; ++i) {
            double d = Maths.boundedRandom(0.0, 1.0);
            network.train(Arrays.asList(d), Arrays.asList(0.0));
        }

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
        for (int i = 0; i < 100000; ++i) {
            double d = Maths.boundedRandom(0.0, 1.0);
            network.train(Arrays.asList(d), Arrays.asList(d));
        }

        List<Double> result = network.evaluate(Arrays.asList(0.5));
        assertEquals(0.5, result.get(0), 0.01);
        result = network.evaluate(Arrays.asList(0.85));
        assertEquals(0.85, result.get(0), 0.01);
        result = network.evaluate(Arrays.asList(0.15));
        assertEquals(0.15, result.get(0), 0.01);
    }

    @Test
    public void testLearnOneMinusX() throws IOException {
        Network network = new Network.Builder().innerLayerCount(0).inputLayerSize(1).outputLayerSize(1)
                .learningRate(0.2).build();
        for (int i = 0; i < 100000; ++i) {
            double d = Maths.boundedRandom(0.0, 1.0);
            network.train(Arrays.asList(d), Arrays.asList(1.0 - d));
        }

        List<Double> result = network.evaluate(Arrays.asList(0.5));
        assertEquals(0.5, result.get(0), 0.01);
        result = network.evaluate(Arrays.asList(0.85));
        assertEquals(0.15, result.get(0), 0.01);
        result = network.evaluate(Arrays.asList(0.15));
        assertEquals(0.85, result.get(0), 0.01);
    }

    @Test
    public void testLearnZero_OneInnerLayer() throws IOException {
        Network network = new Network.Builder().innerLayerCount(1).innerLayerSize(1).inputLayerSize(1).outputLayerSize(1)
                .learningRate(0.2).build();
        for (int i = 0; i < 50000; ++i) {
            double d = Maths.boundedRandom(0.0, 1.0);
            network.train(Arrays.asList(d), Arrays.asList(0.0));
        }

        List<Double> result = network.evaluate(Arrays.asList(0.5));
        assertEquals(0.0, result.get(0), 0.01);
        result = network.evaluate(Arrays.asList(0.85));
        assertEquals(0.0, result.get(0), 0.01);
        result = network.evaluate(Arrays.asList(0.15));
        assertEquals(0.0, result.get(0), 0.01);
    }

    @Test
    public void testXor() {
        var network = new Network.Builder().learningRate(0.5).inputLayerSize(2).innerLayerSize(3).outputLayerSize(1)
                .innerLayerCount(2).build();
        for (int i=0; i<1000; ++i) {
            network.train(Arrays.asList(0.0, 0.0), Arrays.asList(0.0));
            network.train(Arrays.asList(0.0, 1.0), Arrays.asList(1.0));
            network.train(Arrays.asList(1.0, 0.0), Arrays.asList(1.0));
            network.train(Arrays.asList(1.0, 1.0), Arrays.asList(0.0));
        }

        List<Double> result;
        result = network.evaluate(Arrays.asList(0.0, 0.0));
        assertEquals(0.0, result.get(0), 0.2);
        result = network.evaluate(Arrays.asList(0.0, 1.0));
        assertEquals(1.0, result.get(0), 0.2);
        result = network.evaluate(Arrays.asList(1.0, 0.0));
        assertEquals(1.0, result.get(0), 0.2);
        result = network.evaluate(Arrays.asList(1.0, 1.0));
        assertEquals(0.0, result.get(0), 0.2);
    }
}