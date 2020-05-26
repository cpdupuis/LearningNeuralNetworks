package com.bitsforabetterworld.learningnn;

import java.util.ArrayList;
import java.util.List;

public class OutputLayer extends Layer {
    private final List<OutputNeuron> neurons;

    public OutputLayer(Network network, Layer previous) {
        int neuronCount =  network.getOutputLayerSize();
        this.neurons = new ArrayList<>(neuronCount);
        for (int i = 0; i < neuronCount; ++i) {
            List<Synapse> synapses = new ArrayList<>();
            for (var neuron : previous.getNeurons()) {
                synapses.add(new Synapse(network.getLearningRate(), neuron));
            }
            OutputNeuron neuron = new OutputNeuron(synapses, network.createId());
            neurons.add(neuron);
        }
    }

    @Override
    public List<OutputNeuron> getNeurons() {
        return neurons;
    }
}