package com.bitsforabetterworld.learningnn;

public class Synapse {
    private final Neuron neuron;
    private final Settings settings;
    private double weight;

    public Synapse(Settings settings, Neuron neuron) {
        this.neuron = neuron;
        this.settings = settings;
        this.weight = Maths.randomWeight();
    }

    public double getWeightedValue() {
        return weight * neuron.getOutputValue();
    }

    public double getUnweightedValue() {
        return neuron.getOutputValue();
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void updateWeights(double error) {
        // Update my weight according to currentWeight * error
        double currentWeight = weight;
        double correctionFactor = currentWeight * error;
        this.weight += correctionFactor *settings.getLearningRate();
        // Pass on currentWeight * error as the errror to my neuron.
        neuron.updateWeights(correctionFactor);
    }
}