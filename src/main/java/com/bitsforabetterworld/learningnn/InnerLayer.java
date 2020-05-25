package com.bitsforabetterworld.learningnn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;

public class InnerLayer implements Layer {
    private final List<Neuron> neurons;

    public InnerLayer(Network network, Layer previous, boolean withBias) {
        // TODO: refactor to split OutputLayer and InnerLayer
        int neuronCount = withBias ? network.getInnerLayerSize() : network.getOutputLayerSize();
        this.neurons = new ArrayList<>(neuronCount);
        if (withBias) {
            neurons.add(new BiasNeuron(network.createId()));
        }
        for (int i = 0; i < neuronCount; ++i) {
            List<Synapse> synapses = new ArrayList<>();
            for (var neuron : previous.getNeurons()) {
                synapses.add(new Synapse(network.getLearningRate(), neuron));
            }
            LTU ltu = new LTU(synapses, network.createId());
            neurons.add(ltu);
        }
    }

    @Override
    public List<Neuron> getNeurons() {
        return neurons;
    }

    @Override
    public void toJson(JsonGenerator gen) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("type", this.getClass().getSimpleName());
        gen.writeFieldName("neurons");
        gen.writeStartArray();
        for (var neuron : neurons) {
            neuron.toJson(gen);
        }
        gen.writeEndArray();
        gen.writeEndObject();
    }
}
