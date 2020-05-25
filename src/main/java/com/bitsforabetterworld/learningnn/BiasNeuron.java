package com.bitsforabetterworld.learningnn;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

public class BiasNeuron implements Neuron {
    private final long id;

    public BiasNeuron(long id) {
        this.id = id;
    }

    @Override
    public double getOutputValue() {
        return 1.0;
    }

    @Override
    public void reset() {

    }

    @Override
    public void updateWeights(double correctionFactor) {

    }

    @Override
    public void toJson(JsonGenerator gen) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("type", this.getClass().getSimpleName());
        gen.writeNumberField("id", id);
        gen.writeEndObject();
    }

    @Override
    public long getId() {
        return id;
    }
    
}