# 🔋 AdaBoost in Java using Weka

This project demonstrates the implementation of the **AdaBoost** algorithm in **Java** using the Weka machine learning library.

## 🛠️ Requirements

- Java 8 or above
- Weka library (add `weka.jar` to your classpath)
- ARFF dataset file (e.g., `data.arff`)

## 📄 Description

We use `AdaBoostM1` with a simple base learner `DecisionStump` to classify data.

## 📦 How to Run

1. Place your dataset (e.g., `data.arff`) in the root folder.
2. Compile and run the code:

import weka.classifiers.meta.AdaBoostM1;
import weka.classifiers.trees.DecisionStump;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class AdaBoostExample {
    public static void main(String[] args) throws Exception {
        // Load dataset
        DataSource source = new DataSource("data.arff");
        Instances data = source.getDataSet();
        if (data.classIndex() == -1)
            data.setClassIndex(data.numAttributes() - 1);

        // Setup AdaBoost
        AdaBoostM1 boost = new AdaBoostM1();
        boost.setClassifier(new DecisionStump());
        boost.setNumIterations(10);
        boost.buildClassifier(data);

        System.out.println(boost);
    }
}

```bash
javac -cp weka.jar AdaBoostExample.java
java -cp .:weka.jar AdaBoostExample

