package com.bitsforabetterworld.learningnn;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

public interface Neuron {
    double getOutputValue();
    void updateNeuronWeight(double correctionFactor);
    void reset();
    void toJson(JsonGenerator gen) throws IOException;
    long getId();
}
