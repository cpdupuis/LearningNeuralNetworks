package com.bitsforabetterworld.learningnn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InputLayer implements Layer {

    private List<InputNeuron> neurons;

    public InputLayer(int neuronCount) {
        neurons = new ArrayList<InputNeuron>(neuronCount);
        for (int i=0; i<neuronCount; ++i) {
            neurons.add(new InputNeuron());
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
