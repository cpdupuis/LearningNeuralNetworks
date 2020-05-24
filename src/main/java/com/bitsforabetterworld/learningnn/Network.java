package com.bitsforabetterworld.learningnn;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private final InputLayer inputLayer;
    private final Layer outputLayer;
    private final ArrayList<Neuron> allNeurons;


    public Network(double learningRate, int inputSize, int innerSize, int outputSize, int innerLayers) {
        this.inputLayer = new InputLayer(inputSize);
        allNeurons = new ArrayList<>(inputLayer.getNeurons());
        Layer prev = this.inputLayer;
        for (int i=0; i<innerSize; ++i) {
            InnerLayer curr = new InnerLayer(learningRate, innerSize, prev);
            allNeurons.addAll(curr.getNeurons());
            prev = curr;
        }
        this.outputLayer = new InnerLayer(learningRate, outputSize, prev);
        allNeurons.addAll(outputLayer.getNeurons());
    }

    public void reset() {
        for (var neuron : allNeurons) {
            neuron.reset();
        }
    }

    public void learn(List<Double> input, List<Double> expectedOutput) {
        List<Double> result = evaluate(input);
        double totalError = 0.0;
        double chiSquaredError = 0.0;
        if (expectedOutput.size() != result.size()) {
            throw new ValidationException("Mismatch between expectedOutput size and output layer size");
        }
        for (int i=0; i<result.size(); ++i) {
            // error is the amount that the result needs to be corrected by in order to be correct
            double error = expectedOutput.get(i) - result.get(i);
            totalError += error;
            chiSquaredError += (error * error);
            outputLayer.getNeurons().get(i).updateWeights(error);
        }
        System.out.println("Error report chi2="+chiSquaredError+" totalErr="+totalError);
    }
    
    public List<Double> evaluate(List<Double> input) {
        reset();
        inputLayer.setInput(input);
        List<Double> result = new ArrayList<>(outputLayer.getNeurons().size());
        for (var neuron : outputLayer.getNeurons()) {
            result.add(neuron.getOutputValue());
        }
        return result;
    }
}