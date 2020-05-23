package com.bitsforabetterworld.learningnn;

// Linear Threshold Unit. See this page https://medium.com/@srajaninnov/introduction-to-neural-networks-11b009f1a97b
public class LTU implements Neuron {
    private final Iterable<Synapse> inputs;

    public LTU(Iterable<Synapse> inputs) {
        this.inputs = inputs;
    }

    @Override
    public double getOutputValue() {
        double sum = 0.0;
        for (var input : inputs) {
            sum += input.getValue();
        }
        return Maths.activationFunction(sum);
    }
}
