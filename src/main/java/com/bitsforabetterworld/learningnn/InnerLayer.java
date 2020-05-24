package com.bitsforabetterworld.learningnn;

import java.util.ArrayList;
import java.util.List;

public class InnerLayer implements Layer {
    private final List<Neuron> neurons;

    public InnerLayer(Settings settings, int neuronCount, Layer previous) {
        // Create 1 additional neuron as a bias element
        this.neurons = new ArrayList<>(neuronCount + 1);
        neurons.add(new BiasNeuron());
        for (int i=0; i<neuronCount; ++i) {
            
            List<Synapse> synapses = new ArrayList<>();
            for (var neuron : previous.getNeurons()) {
                synapses.add(new Synapse(settings, neuron));
            }
            LTU ltu = new LTU(synapses);
            neurons.add(ltu);
        }
    }

    @Override
    public Iterable<Neuron> getNeurons() {
        return neurons;
    }
}
