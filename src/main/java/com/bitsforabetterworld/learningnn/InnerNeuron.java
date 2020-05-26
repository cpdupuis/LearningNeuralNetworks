package com.bitsforabetterworld.learningnn;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

// Linear Threshold Unit. See this page https://medium.com/@srajaninnov/introduction-to-neural-networks-11b009f1a97b
public class InnerNeuron extends Neuron {
    private final Iterable<Synapse> synapses;

    public InnerNeuron(Iterable<Synapse> synapses, long id) {
        super(id);
        this.synapses = synapses;
    }

    @Override
    public double getValue() {
        if (Double.isNaN(value)) {
            double sum = 0.0;
            for (var synapse : synapses) {
                sum += synapse.getWeightedValue();
            }
            value = sum;
        }
        return value;
    }

    @Override
    public void updateNeuronWeight(double error) {
        double totalWeightMagnitude = 0.0;
        for (var synapse : synapses) {
            totalWeightMagnitude += Math.abs(synapse.getWeight());
        }
        if (totalWeightMagnitude > 0.0) {
            for (var synapse : synapses) {
                synapse.updateWeights(error * Math.abs(synapse.getWeight()) / totalWeightMagnitude);
            }
        }
    }

    @Override
    public void serializeSynapses(JsonGenerator gen) throws IOException {
        gen.writeFieldName("synapses");
        gen.writeStartArray();
        for (var synapse : synapses) {
            synapse.toJson(gen);
        }
        gen.writeEndArray();
    }

}
