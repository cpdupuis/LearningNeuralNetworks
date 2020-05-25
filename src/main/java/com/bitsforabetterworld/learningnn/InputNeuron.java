package com.bitsforabetterworld.learningnn;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

public class InputNeuron extends Neuron {

    public InputNeuron(long id) {
        super(id);
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public void updateNeuronWeight(double correctionFactor) {
        // no-op
    }

    @Override
    public void serializeSynapses(JsonGenerator gen) throws IOException {
        // no-op
    }

    @Override
    public double getOutputValue() {
        return value;
    }
}
