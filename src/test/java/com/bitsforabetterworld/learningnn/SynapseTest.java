package com.bitsforabetterworld.learningnn;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

public class SynapseTest {
    @Mock
    private Neuron mockNeuron;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testWeightedValue() {
        double learningRate = 0.5;
        Synapse synapse = new Synapse(learningRate, mockNeuron);
        double weight = synapse.getWeight();
        assertNotEquals(0.0, weight); // Not very likely anyway.
        doReturn(Math.PI).when(mockNeuron).getValue();
        assertEquals(Math.PI * weight, synapse.getWeightedValue());
    }

    @Test
    public void testUpdateWeight() {
        double learningRate = 0.5;
        Synapse synapse = new Synapse(learningRate, mockNeuron);
        double weight = synapse.getWeight();
        doReturn(0.6).when(mockNeuron).getValue();

        synapse.updateWeights(0.8);
        double newWeight = synapse.getWeight();
        assertEquals(weight + learningRate * 0.8, newWeight);
        Mockito.verify(mockNeuron).updateNeuronWeight(Mockito.eq(0.8));
    }
}
