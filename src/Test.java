
public class Test {
    public static void main(String[] args) {

        double[] inputs = {1,2};
        double true_value = 1;
        double[][] weights = {
                {0.5, -0.5},
                {0.3, 0.8}

        };
        double[] bias = {0.1, -0.2};
        double[] output_weights = {1.0, -1.0};
        double output_bias = 0.5;


        FeedForward forward = new FeedForward();
        Activation relu = new Relu();
        Backpropagation backprop = new Backpropagation();

        double[] z = forward.feedforward(inputs, weights, bias, relu); // feedforward
        double output = forward.output(z, output_weights, output_bias); // output layer calculation.
        double loss = forward.loss(output, true_value); // Calculate Loss
        double delta = backprop.output_gradient(output, true_value);

        System.out.println(Double.toString(delta));

    }
}
