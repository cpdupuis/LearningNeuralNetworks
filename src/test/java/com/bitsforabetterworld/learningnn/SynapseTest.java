package com.bitsforabetterworld.learningnn;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SynapseTest {
    @Test
    public void testWeightedValue() {
        InputNeuron neuron = new InputNeuron(1);
        neuron.setValue(Math.PI);
        Synapse synapse = new Synapse(0.5, neuron);
        double weight = synapse.getWeight();
        assertNotEquals(0.0, weight); // Not very likely anyway.
        assertEquals(Math.PI * weight, synapse.getWeightedValue());
    }
    
}