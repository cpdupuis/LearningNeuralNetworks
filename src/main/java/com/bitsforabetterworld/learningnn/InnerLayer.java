package com.bitsforabetterworld.learningnn;

import java.util.ArrayList;
import java.util.List;

public class InnerLayer implements Layer {
    private final List<Neuron> neurons;

    public InnerLayer(double learningRate, int neuronCount, Layer previous, boolean withBias) {
        this.neurons = new ArrayList<>(neuronCount);
        if (withBias) {
            neurons.add(new BiasNeuron());
        }
        for (int i=0; i<neuronCount; ++i) {
            
            List<Synapse> synapses = new ArrayList<>();
            for (var neuron : previous.getNeurons()) {
                synapses.add(new Synapse(learningRate, neuron));
            }
            LTU ltu = new LTU(synapses);
            neurons.add(ltu);
        }
    }

    @Override
    public List<Neuron> getNeurons() {
        return neurons;
    }
}
