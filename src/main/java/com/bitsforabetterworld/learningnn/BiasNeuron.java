package com.bitsforabetterworld.learningnn;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

public class BiasNeuron extends Neuron {

    public BiasNeuron(long id) {
        super(id);
    }

    @Override
    public double getValue() {
        return 1.0;
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