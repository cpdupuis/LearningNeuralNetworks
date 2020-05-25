package com.bitsforabetterworld.learningnn;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;

public abstract class Layer {

    public abstract List<? extends Neuron> getNeurons();
    public void toJson(JsonGenerator gen) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("type", this.getClass().getSimpleName());
        gen.writeFieldName("neurons");
        gen.writeStartArray();
        for (var neuron : getNeurons()) {
            neuron.toJson(gen);
        }
        gen.writeEndArray();
        gen.writeEndObject();

    }
}
