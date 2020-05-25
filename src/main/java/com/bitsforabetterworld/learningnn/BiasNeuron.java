package com.bitsforabetterworld.learningnn;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

public class BiasNeuron extends Neuron {
    private static final double biasValue = 1.0;

    public BiasNeuron(long id) {
        super(id);
    }

    @Override
    public double getOutputValue() {
        return biasValue;
    }

    @Override
    public void updateNeuronWeight(double correctionFactor) {
        // no-op
    }

    @Override
    public void serializeSynapses(JsonGenerator gen) throws IOException {
        // no-op
    }    
}