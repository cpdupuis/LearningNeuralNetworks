package com.bitsforabetterworld.learningnn;

public class Synapse {
    private final Neuron neuron;
    private double weight;

    public Synapse(Neuron neuron) {
        this.neuron = neuron;
        this.weight = Maths.random();
    }

    public double getValue() {
        return weight * neuron.getOutputValue();
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    // TODO: Can I replace setWeight with a "learn" or "backpropagate" function?
}