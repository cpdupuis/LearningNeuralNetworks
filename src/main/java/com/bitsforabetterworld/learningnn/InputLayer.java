package com.bitsforabetterworld.learningnn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InputLayer extends Layer {

    private List<InputNeuron> neurons;

    public InputLayer(Network network) {
        neurons = new ArrayList<InputNeuron>(network.getInputLayerSize());
        for (int i = 0; i < network.getInputLayerSize(); ++i) {
            neurons.add(new InputNeuron(network.createId()));
        }
    }

    public void setInput(List<Double> inputs) {
        if (inputs.size() != neurons.size()) {
            throw new ValidationException("Mismatch of input size");
        }
        Iterator<Double> inputIter = inputs.iterator();
        Iterator<InputNeuron> neuronIter = neurons.iterator();
        while (inputIter.hasNext()) {
            neuronIter.next().setValue(inputIter.next());
        }
    }

    @Override
    public List<InputNeuron> getNeurons() {
        return neurons;
    }
}
