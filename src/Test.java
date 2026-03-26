
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
        int epoch = 5;
        double tolerance = 1e-6;


        FeedForward forward = new FeedForward();
        Activation relu = new Relu();
        Backpropagation backprop = new Backpropagation();
        
        for(int i = 0; i < epoch; i++){
            double[] z = forward.feedforward(inputs, weights, bias, relu); // feedforward
            double output = forward.output(z, output_weights, output_bias); // output layer calculation.
            double loss = forward.loss(output, true_value); // Calculate Loss
            if (Math.abs(loss) < tolerance){
                System.out.println("Loss has been maximized and reach lowed.");
                break;
            }
            double delta = backprop.output_gradient(output, true_value);
            double[] gradient_output_weights = backprop.gradient_output_weights(delta, z);
            double[] backdrop_hidden_layer = backprop.backdrop_hidden_layer(delta, output_weights, z);
            double[][] gradients_hidden_Layer = backprop.gradients_hidden_Layer(backdrop_hidden_layer, inputs);

            // updating the weights
            output_weights = backprop.update_output_weights(gradient_output_weights, output_weights);
            weights = backprop.update_weights(gradients_hidden_Layer, weights);
            System.err.println("weights " + java.util.Arrays.deepToString(weights));
        }



        System.out.print(java.util.Arrays.deepToString(weights));

    }
}
