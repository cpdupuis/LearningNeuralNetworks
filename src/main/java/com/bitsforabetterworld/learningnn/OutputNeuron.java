package com.bitsforabetterworld.learningnn;

// It's a subclass to make the serialized form easier to read.
public class OutputNeuron extends InnerNeuron {

    public OutputNeuron(Iterable<Synapse> synapses, long id) {
        super(synapses, id);
    }
}