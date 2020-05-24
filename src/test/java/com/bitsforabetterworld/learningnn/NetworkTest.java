package com.bitsforabetterworld.learningnn;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class NetworkTest {
    @Test
    public void testXor() {
        Network network = new Network(0.2, 2, 0, 1, 0);
        network.train(Arrays.asList(0.0, 0.0), Arrays.asList(0.0));
        network.train(Arrays.asList(0.0, 1.0), Arrays.asList(1.0));
        network.train(Arrays.asList(1.0, 0.0), Arrays.asList(1.0));
        network.train(Arrays.asList(1.0, 1.0), Arrays.asList(0.0));
        
    }
}