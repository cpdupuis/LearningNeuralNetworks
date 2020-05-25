package com.bitsforabetterworld.learningnn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;

public class InputLayer implements Layer {

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

    @Override
    public void toJson(JsonGenerator gen) throws IOException {
        // TODO Auto-generated method stub

    }
}
