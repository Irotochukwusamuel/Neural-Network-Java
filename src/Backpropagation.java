
import java.util.Arrays;



public class Backpropagation {

    double[][] weights;
    double[] bias;
    double learning_rate = 0.01;

    public double output_gradient(double predicted_value, double true_value){
        return predicted_value - true_value;
    }

    public double[] gradient_output_weights(double output_gradient, double[] z){
        double[] result = new double[z.length];
        for(int i = 0; i < z.length; i++){
            result[i] = output_gradient * z[i];
        }
        return result;
    }

    public double[] backdrop_hidden_layer(double output_gradient, double[] weights, double[] z){
        double[] result = new double[weights.length];

        for(int i = 0; i < weights.length; i++){
            double relu_derivative = (z[i] > 0) ? 1 : 0.01;
            result[i] = (output_gradient * weights[i]) * relu_derivative;
        }
        return result;
    }

    public double[][] gradients_hidden_Layer(double[] backdrop_hidden_layer, double[] inputs){
        double[][] results = new double[backdrop_hidden_layer.length][inputs.length];
        double[] bias = new double[inputs.length];
        for (int b = 0; b < backdrop_hidden_layer.length; b++) {
            for (int i = 0; i < inputs.length; i++) {
                results[b][i] = backdrop_hidden_layer[b] * inputs[i];
            }
            bias[b] = backdrop_hidden_layer[b];
        }
        return results;
    }

    public double[] update_bias(double[] hidden_gradient, double[] bias){
        for(int i = 0; i < bias.length; i++){
            bias[i] -= learning_rate * hidden_gradient[i];
        }
        return bias;
    }

    public double update_output_bias(double delta, double output_bias){
        return output_bias - learning_rate * delta;
    }

    public double[]  update_output_weights(double[] gradient_output_weights, double[] output_weights){
        for(int i = 0; i < output_weights.length; i++){
            output_weights[i] = output_weights[i] - (this.learning_rate * gradient_output_weights[i]);
        }
        return output_weights;
    }

    public double[][] update_weights(double[][] gradients_hidden_Layer, double[][] weights){
        for (int b = 0; b < gradients_hidden_Layer.length; b++) {
            for (int i = 0; i < weights[b].length; i++) {
                weights[b][i] = weights[b][i] - (this.learning_rate * gradients_hidden_Layer[b][i]);
            }
        }
        return weights;
    }








}
