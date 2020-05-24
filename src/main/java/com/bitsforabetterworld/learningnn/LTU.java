package com.bitsforabetterworld.learningnn;

// Linear Threshold Unit. See this page https://medium.com/@srajaninnov/introduction-to-neural-networks-11b009f1a97b
public class LTU implements Neuron {
    private final Iterable<Synapse> inputs;
    private double currentOutput = Double.NaN;

    public LTU(Iterable<Synapse> inputs) {
        this.inputs = inputs;
    }

    @Override
    public double getOutputValue() {
        if (Double.isNaN(currentOutput)) {
            double sum = 0.0;
            for (var input : inputs) {
                sum += input.getWeightedValue();
            }
            currentOutput = Maths.activationFunction(sum);
        }
        return currentOutput;
    }

    @Override
    public void updateWeights(double expected) {
        double error = expected - currentOutput;
        // Maybe?
        double deltaOutput = error * Maths.derivativeActivationFunction(error);
        for (var synapse : inputs) {
            synapse.updateWeights(deltaOutput);
        }
    }

    @Override
    public void reset() {
        currentOutput = Double.NaN;
    }
}
