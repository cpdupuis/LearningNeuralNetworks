package com.bitsforabetterworld.learningnn;

public interface Neuron {
    double getOutputValue();
    void updateWeights(double correctionFactor);
    void reset();
}
