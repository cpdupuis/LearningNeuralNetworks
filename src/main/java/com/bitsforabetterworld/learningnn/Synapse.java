package com.bitsforabetterworld.learningnn;

public class Synapse {
    private final Neuron neuron;
    private final double learningRate;
    private double weight;

    public Synapse(double learningRate, Neuron neuron) {
        this.neuron = neuron;
        this.learningRate = learningRate;
        this.weight = Maths.randomWeight();
    }

    public double getWeightedValue() {
        return weight * neuron.getOutputValue();
    }

    public void updateWeights(double error) {
        // Update my weight according to currentWeight * error
        double currentWeight = weight;
        double correctionFactor = currentWeight * error;
        this.weight += correctionFactor *learningRate;
        // Pass on currentWeight * error as the errror to my neuron.
        neuron.updateWeights(correctionFactor);
    }
}