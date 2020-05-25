package com.bitsforabetterworld.learningnn;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

public interface Neuron {
    double getOutputValue();
    void updateWeights(double correctionFactor);
    void reset();
    void toJson(JsonGenerator gen) throws IOException;
    long getId();
}
