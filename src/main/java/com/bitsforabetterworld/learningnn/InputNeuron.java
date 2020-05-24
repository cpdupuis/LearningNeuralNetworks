package com.bitsforabetterworld.learningnn;

public class InputNeuron implements Neuron {
    private double value;

    public InputNeuron() {
        this.value = Double.NaN;
    }
    
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public double getOutputValue() {
        return value;
    }

    @Override
    public void reset() {
        value = Double.NaN;
    }

    @Override
    public void updateWeights(double correctionFactor) {
        // no-op
    }
}