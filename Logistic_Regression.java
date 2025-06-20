import java.util.Arrays;

public class LogisticRegression {
    private double[] coefficients;
    private double learningRate;
    private int iterations;

    public LogisticRegression(double learningRate, int iterations) {
        this.learningRate = learningRate;
        this.iterations = iterations;
    }

    public void fit(double[][] X, double[] y) {
        int m = X.length; // number of training examples
        int n = X[0].length; // number of features
        coefficients = new double[n + 1]; // +1 for the intercept

        // Gradient Descent
        for (int it = 0; it < iterations; it++) {
            double[] gradients = new double[n + 1];
            for (int i = 0; i < m; i++) {
                double predicted = predictProb(X[i]);
                double error = predicted - y[i];
                gradients[0] += error; // intercept gradient
                for (int j = 0; j < n; j++) {
                    gradients[j + 1] += error * X[i][j];
                }
            }
            for (int j = 0; j < coefficients.length; j++) {
                coefficients[j] -= (learningRate / m) * gradients[j];
            }
        }
    }

    public double predictProb(double[] x) {
        double z = coefficients[0]; // intercept
        for (int i = 0; i < x.length; i++) {
            z += coefficients[i + 1] * x[i];
        }
        return 1.0 / (1.0 + Math.exp(-z));
    }

    public int predict(double[] x) {
        return predictProb(x) >= 0.5 ? 1 : 0;
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public static void main(String[] args) {
        // Example usage
        double[][] X = {
            {1, 2},
            {2, 3},
            {3, 4},
            {5, 6}
        };
        double[] y = {0, 0, 1, 1};

        LogisticRegression model = new LogisticRegression(0.1, 1000);
        model.fit(X, y);

        System.out.println("Coefficients: " + Arrays.toString(model.getCoefficients()));
        double[] newSample = {4, 5};
        System.out.println("Predicted class: " + model.predict(newSample));
    }
}
