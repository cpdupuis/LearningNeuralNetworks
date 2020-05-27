# What is a neural network

A neural network is a mathematical function mapping a list of inputs to a list of outputs.

A 3-level neural network is a mathematical function of the form:

f(W2, f(W1, f(W0, I)))

Where the function f(W, I) is defined as:

f(W,I,n)[j] = sum from 1 to n over W[i] * I[i]


There is nothing magical about a neural network. It's math. Just like everything 
in programming.


From here: https://www.nnwj.de/backpropagation.html

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
