public class Backpropagation {

    public double output_gradient(double predicted_value, double true_value){
        return predicted_value - true_value;
    }

    public double[] gradient_output_weights(double output_gradient, double[] weights){
        double[] result = new double[weights.length];
        for(int i = 0; i < weights.length; i++){
            result[i] = output_gradient * weights[i];
        }
        return result;
    }

    public double[] backdrop_hidden_layer(double output_gradient, double[] weights, double[] z){
        double[] result = new double[weights.length];

        for(int i = 0; i < weights.length; i++){
            result[i] = (output_gradient * weights[i]) * Math.max(0, z[i]);
        }
        return result;
    }

    public double[][] gradients_hidden_Layer(double[] backdrop_hidden_layer, double[] inputs){
        double[][] results = new double[backdrop_hidden_layer.length][inputs.length];
        
        for (int i = 0; i < backdrop_hidden_layer.length; i++) {
            
        }

        return results;
    }







}
