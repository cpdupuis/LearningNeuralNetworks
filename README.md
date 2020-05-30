# LearningNeuralNetworks

This is a project I created to let me learn about how neural networks work at a basic level,
using just primitives like multiplication and exponentiation.

So far, this is only exercised through the unit tests in NetworkTest.java

A neural network in this package consists of:

- Neuron: a neuron is a unit that can provide a value
- InputNeuron: an input neuron provides the value that has been set for it, for example, through input
- InnerNeuron: an inner neuron provides a value based on the weighted sum of the values of the neurons
    in the previous layer
- OutputNeuron: an output neuron is currently just an inner neuron with a different class name, to allow
    for easier serialization
- Synapse: a synapse is a link to a neuron that has a weight (initially random) associated with it.
- Layer: a layer contains a list of neurons.
- InputLayer: a layer containing InputNeurons that provides a method for setting the input for the layer
- InnerLayer: a layer containing InnerNeurons
- OutputLayer: a layer containing OutputNeurons that provides a method for getting the output from the layer
- Network: a network creates layers and allows training and evaluation of the model


