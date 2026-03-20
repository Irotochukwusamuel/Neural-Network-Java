import java.util.Arrays;

public class FeedForward {
    public double[] feedforward(double[] inputs, double[][] weights, double[] bias, Activation activation){

        if(weights.length != bias.length){
            throw new IllegalArgumentException("Bias size must match number of neurons");
        }

        double[] result = new double[weights.length];

        for(int w = 0; w < weights.length; w++){
            double res = 0;
            for(int i = 0; i < weights[w].length; i++){
                res += (weights[w][i] * inputs[i]);
            }
            result[w] = activation.function(res + bias[w]);
        }

        return result;
    }

    public double output(double[] weights, double[] output_w, double output_bias){
        double result = 0;
        for(int i = 0; i < weights.length; i++ ){
           result += weights[i] * output_w[i];
        }
        result += output_bias;
        return result;
    }

    public double loss(double output, double true_value){
        return  0.5 * Math.pow(2, (output - true_value));
    }
}
