package com.bitsforabetterworld.learningnn;

import java.util.ArrayList;
import java.util.List;

public class InnerLayer extends Layer {
    private final List<Neuron> neurons;

    public InnerLayer(Network network, Layer previous) {
        int neuronCount = network.getInnerLayerSize();
        this.neurons = new ArrayList<>(neuronCount + 1); // add 1 for the bias neuron
        neurons.add(new BiasNeuron(network.createId()));
        for (int i = 0; i < neuronCount; ++i) {
            List<Synapse> synapses = new ArrayList<>();
            for (var neuron : previous.getNeurons()) {
                synapses.add(new Synapse(network.getLearningRate(), neuron));
            }
            InnerNeuron innerNeuron = new InnerNeuron(synapses, network.createId());
            neurons.add(innerNeuron);
        }
    }

    @Override
    public List<Neuron> getNeurons() {
        return neurons;
    }

}
