package com.bitsforabetterworld.learningnn;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

// Linear Threshold Unit. See this page https://medium.com/@srajaninnov/introduction-to-neural-networks-11b009f1a97b
public class LTU implements Neuron {
    private final Iterable<Synapse> inputs;
    private double currentOutput = Double.NaN;
    private final long id;

    public LTU(Iterable<Synapse> inputs, long id) {
        this.inputs = inputs;
        this.id = id;
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
        double deltaOutput = error * Maths.derivativeActivationFunction(-error);
        for (var synapse : inputs) {
            synapse.updateWeights(deltaOutput);
        }
    }

    @Override
    public void reset() {
        currentOutput = Double.NaN;
    }

    @Override
    public void toJson(JsonGenerator gen) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("type", this.getClass().getSimpleName());
        gen.writeNumberField("id", id);
        gen.writeFieldName("synapses");
        gen.writeStartArray();
        for (var synapse : inputs) {
            synapse.toJson(gen);
        }
        gen.writeEndArray();
        gen.writeEndObject();
    }

    @Override
    public long getId() {
        return id;
    }
}
