package com.bitsforabetterworld.learningnn;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

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

    public void toJson(JsonGenerator gen) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("type", this.getClass().getSimpleName());
        gen.writeNumberField("neuron", neuron.getId());
        gen.writeNumberField("weight", weight);
        gen.writeEndObject();
    }
}