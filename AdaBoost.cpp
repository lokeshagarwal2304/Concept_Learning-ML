### 📁 `cpp-boosting/README.md`

```markdown
# ⚙️ Boosting in C++ using XGBoost

This project implements **Gradient Boosting** in **C++** using the official **XGBoost C++ API**.

## 🛠️ Requirements

- C++11 or above
- XGBoost (compiled from source)

## 🔧 Build XGBoost

Follow official instructions to build XGBoost:
https://xgboost.readthedocs.io/en/stable/build.html

## 📄 Dataset

The training data must be in `libsvm` format (e.g., `train.svm`)

## 🚀 How to Run

1. Place your dataset `train.svm` in the root.
2. Compile the code:

```bash
g++ boost.cpp -o boost -I/path/to/xgboost/include -L/path/to/xgboost/lib -lxgboost
