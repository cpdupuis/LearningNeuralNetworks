package com.bitsforabetterworld.learningnn;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

public class Synapse {
    private final Neuron neuron;
    private final double learningRate;
    private double weight;

    public Synapse(double learningRate, Neuron neuron) {
        this.neuron = neuron;
        this.learningRate = learningRate;
        this.weight = Maths.randomWeight();
    }

    public double getWeightedValue() {
        return weight * neuron.getValue();
    }

    public double getWeight() {
        return weight;
    }

    public void updateWeights(double error, double predecessorOutput) {
        /* 
This is the core of backpropagation. This code is based on info from this source: https://www.nnwj.de/backpropagation.html
The most important bit from there:

The formula of sigmoid activation is:

               1
    f(x) = ---------
           1 + e-input

The algorithm works as follows:

    Perform the forwardpropagation phase for an input pattern and calculate the output error
    Change all weight values of each weight matrix using the formula 
    weight(old) + learning rate * output error * output(neurons i) * output(neurons i+1) * ( 1 - output(neurons i+1) )

    0.25 * (-0.643962658) * 0.634135591
                                * 0.643962658 * (1-0.643962658)
    Go to step 1
    The algorithm ends, if all output patterns match their target pattern

    Update weight:

    W = w + L * Err * myoutput * parentOutput * (1 - parentOutput)

    Inner and output neurons use sigmoid for activation.

        */

        // W = w + L * Err * myoutput * parentOutput * (1 - parentOutput)
        weight = weight + learningRate * error * neuron.getValue() * Maths.derivativeActivationFunction(predecessorOutput);
        neuron.updateNeuronWeight(error);
    }

    public void toJson(JsonGenerator gen) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("type", this.getClass().getSimpleName());
        gen.writeNumberField("neuron", neuron.getId());
        gen.writeNumberField("weight", weight);
        gen.writeEndObject();
    }
}