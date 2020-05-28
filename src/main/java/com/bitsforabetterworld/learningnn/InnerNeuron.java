package com.bitsforabetterworld.learningnn;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

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
            value = Maths.sigmoid(sum);
        }
        return value;
    }

    @Override
    public void updateNeuronWeight(double error) {
        for (var synapse : synapses) {
            synapse.updateWeights(error, this.value);
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
