abstract class Activation {
    public abstract double function(double x);
}

abstract class VectorActivation {
    public abstract double[] function(double[] x);
}

class Relu extends Activation {
    @Override
    public double function(double x) {
        return Math.max(0, x);
    }
}

class Softmax extends VectorActivation {
    @Override
    public double[] function(double[] x) {
        double[] nums = new double[x.length];
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            double exp = Math.exp(x[i]);
            nums[i] = exp;
            sum += exp;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] / sum;
        }
        return nums;
    }
}

class Sigmoid extends Activation {
    @Override
    public double function(double x) {
        return 1 / (1 + Math.exp(-x));
    }
}
