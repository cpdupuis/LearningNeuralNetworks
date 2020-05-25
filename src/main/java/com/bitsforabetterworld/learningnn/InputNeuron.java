package com.bitsforabetterworld.learningnn;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

public class InputNeuron implements Neuron {
    private double value;
    private long id;

    public InputNeuron(long id) {
        this.value = Double.NaN;
        this.id = id;
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
    public void updateNeuronWeight(double correctionFactor) {
        // no-op
    }

    @Override
    public void toJson(JsonGenerator gen) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("type", this.getClass().getSimpleName());
        gen.writeNumberField("id", id);
        gen.writeNumberField("inputValue", value);
        gen.writeEndObject();
    }

    @Override
    public long getId() {
        return id;
    }
}
