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
        return weight * neuron.getValue();
    }

    public double getWeight() {
        return weight;
    }

    public void updateWeights(double error, double predecessorOutput) {
        // W = w + L * Err * myoutput * parentOutput * (1 - parentOutput)
        weight = weight + learningRate * error * neuron.getValue() * predecessorOutput * (1 - predecessorOutput);
        neuron.updateNeuronWeight(error);
    }

    public void toJson(JsonGenerator gen) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("type", this.getClass().getSimpleName());
        gen.writeNumberField("neuron", neuron.getId());
        gen.writeNumberField("weight", weight);
        gen.writeEndObject();
    }
}