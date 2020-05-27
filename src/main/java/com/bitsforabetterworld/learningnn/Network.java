package com.bitsforabetterworld.learningnn;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

public class Network {
    private final InputLayer inputLayer;
    private final OutputLayer outputLayer;
    private final ArrayList<Neuron> allNeurons;
    private final List<Layer> allLayers;
    private static final JsonFactory jsonFactory = new JsonFactory();
    private long ids = 0;
    private final double learningRate;
    private final int inputLayerSize;
    private final int innerLayerSize;
    private final int outputLayerSize;
    private final int innerLayerCount;

    public static class Builder {
        private double learningRate = 0.0;
        private int inputLayerSize = 0;
        private int innerLayerSize = 0;
        private int outputLayerSize = 0;
        private int innerLayerCount = 0;

        public Builder learningRate(double rate) {
            this.learningRate = rate;
            return this;
        }

        public Builder inputLayerSize(int count) {
            this.inputLayerSize = count;
            return this;
        }

        public Builder innerLayerSize(int count) {
            this.innerLayerSize = count;
            return this;
        }

        public Builder outputLayerSize(int count) {
            this.outputLayerSize = count;
            return this;
        }

        public Builder innerLayerCount(int count) {
            this.innerLayerCount = count;
            return this;
        }

        public Network build() {
            return new Network(this);
        }

    }

    private Network(Builder builder) {
        this.learningRate = builder.learningRate;
        this.inputLayerSize = builder.inputLayerSize;
        this.innerLayerSize = builder.innerLayerSize;
        this.outputLayerSize = builder.outputLayerSize;
        this.innerLayerCount = builder.innerLayerCount;
        this.allLayers = new ArrayList<>();
        this.inputLayer = new InputLayer(this);
        allLayers.add(inputLayer);
        allNeurons = new ArrayList<>(inputLayer.getNeurons());
        Layer prev = this.inputLayer;
        for (int i = 0; i < innerLayerCount; ++i) {
            InnerLayer curr = new InnerLayer(this, prev);
            allLayers.add(curr);
            allNeurons.addAll(curr.getNeurons());
            prev = curr;
        }
        this.outputLayer = new OutputLayer(this, prev);
        allLayers.add(outputLayer);
        allNeurons.addAll(outputLayer.getNeurons());
    }

    public void reset() {
        for (var neuron : allNeurons) {
            neuron.reset();
        }
    }

    // returns chi-squared error
    public void train(List<Double> input, List<Double> expectedOutput) {
        List<Double> result = evaluate(input);
        if (expectedOutput.size() != result.size()) {
            throw new ValidationException("Mismatch between expectedOutput size and output layer size");
        }
        for (int i = 0; i < result.size(); ++i) {
            // error is the amount that the result needs to be corrected by in order to be
            // correct
            double error = expectedOutput.get(i) - result.get(i);
            outputLayer.getNeurons().get(i).updateNeuronWeight(error);
        }
    }

    public List<Double> evaluate(List<Double> input) {
        reset();
        inputLayer.setInput(input);
        List<Double> result = new ArrayList<>(outputLayer.getNeurons().size());
        for (var neuron : outputLayer.getNeurons()) {
            result.add(neuron.getValue());
        }
        return result;
    }

    public String toJson() throws IOException {
        StringWriter sw = new StringWriter();
        JsonGenerator gen = jsonFactory.createGenerator(sw);
        gen.writeStartObject();
        gen.writeFieldName("layers");
        gen.writeStartArray();
        for (var layer : allLayers) {
            layer.toJson(gen);
        }
        gen.writeEndArray();
        gen.writeEndObject();
        gen.flush();
        return sw.toString();
    }

    public long createId() {
        return ids++;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public int getInputLayerSize() {
        return inputLayerSize;
    }

    public int getInnerLayerSize() {
        return innerLayerSize;
    }

    public int getOutputLayerSize() {
        return outputLayerSize;
    }

    public int getInnerLayerCount() {
        return innerLayerCount;
    }
}