package com.bitsforabetterworld.learningnn;

public class InputNeuron implements Neuron {
    private double value;

    public InputNeuron(double initialValue) {
        this.value = initialValue;
    }
    
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public double getOutputValue() {
        return value;
    }
}