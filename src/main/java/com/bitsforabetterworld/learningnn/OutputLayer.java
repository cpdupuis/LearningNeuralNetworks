package com.bitsforabetterworld.learningnn;

import java.util.ArrayList;
import java.util.List;

public class OutputLayer extends Layer {
    private final List<Neuron> neurons;

    public OutputLayer(Network network, Layer previous) {
        int neuronCount =  network.getOutputLayerSize();
        this.neurons = new ArrayList<>(neuronCount);
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