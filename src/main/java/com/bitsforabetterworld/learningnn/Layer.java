package com.bitsforabetterworld.learningnn;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;

public interface Layer {
    List<? extends Neuron> getNeurons();
    void toJson(JsonGenerator gen) throws IOException;
}
