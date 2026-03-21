public class Backpropagation {

    public double output_gradient(double predicted_value, double true_value){
        return predicted_value - true_value;
    }

    public double gradient_output_layer(double output_gradient, double[] weights){
        double result = 0;
        for(double v : weights){
            result += v * output_gradient;
        }
        return result;
    }





}
