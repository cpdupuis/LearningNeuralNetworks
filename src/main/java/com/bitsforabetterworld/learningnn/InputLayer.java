package com.bitsforabetterworld.learningnn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InputLayer extends Layer {

    private List<Neuron> neurons;

    public InputLayer(Network network) {
        neurons = new ArrayList<Neuron>(network.getInputLayerSize() + 1);
        neurons.add(new BiasNeuron(network.createId()));
        for (int i = 0; i < network.getInputLayerSize(); ++i) {
            neurons.add(new InputNeuron(network.createId()));
        }
    }

    public void setInput(List<Double> inputs) {
        if (inputs.size() != neurons.size() - 1) {
            throw new ValidationException("Mismatch of input size");
        }
        // Assumes the first neuron is a bias neuron
        for (int i=1; i<neurons.size(); ++i) {
            InputNeuron neuron = (InputNeuron) neurons.get(i);
            neuron.setValue(inputs.get(i-1));
        }
    }

    @Override
    public List<Neuron> getNeurons() {
        return neurons;
    }
}
