package com.bitsforabetterworld.learningnn;

import java.util.ArrayList;
import java.util.List;

public class InputLayer implements Layer {

    private List<Neuron> neurons;

    public InputLayer(int neuronCount) {
        neurons = new ArrayList<Neuron>(neuronCount);
        for (int i=0; i<neuronCount; ++i) {
            neurons.add(new InputNeuron());
        }
    }

    @Override
    public Iterable<Neuron> getNeurons() {
        return neurons;
    }
}