package com.bitsforabetterworld.learningnn;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

public abstract class Neuron {
    protected long id;
    protected double value;

    protected Neuron(long id) {
        this.id = id;
        this.value = Double.NaN;
    }

    public abstract void updateNeuronWeight(double correctionFactor);
    protected abstract void serializeSynapses(JsonGenerator gen) throws IOException;

    public void reset() {
        this.value = Double.NaN;
    }
    public void toJson(JsonGenerator gen) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("type", this.getClass().getSimpleName());
        gen.writeNumberField("id", id);
        gen.writeNumberField("value", value);
        serializeSynapses(gen);
        gen.writeEndObject();
    }
    public long getId() {
        return id;
    }

    public double getValue() {
        return value;
    }
}
