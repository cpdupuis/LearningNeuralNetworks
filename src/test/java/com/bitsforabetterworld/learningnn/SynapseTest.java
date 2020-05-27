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
        double totalError = 0.8;
        double nextNeuron = 0.6;
        double prevNeuron = 0.3;
        double oneMinusPrev = 0.7;
        Synapse synapse = new Synapse(learningRate, mockNeuron);
        double weight = synapse.getWeight();
        doReturn(nextNeuron).when(mockNeuron).getValue();
        // W = w + L * Err * myoutput * parentOutput * (1 - parentOutput)
        synapse.updateWeights(totalError, prevNeuron);
        double newWeight = synapse.getWeight();
        assertEquals(weight + learningRate * totalError * nextNeuron * prevNeuron * oneMinusPrev, newWeight);
        Mockito.verify(mockNeuron).updateNeuronWeight(Mockito.eq(totalError));
    }
}
