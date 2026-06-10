import numpy as np
import pandas as pd
from sklearn.linear_model import LogisticRegression
import joblib

# Generate sample data
np.random.seed(42)

marks = np.random.randint(30, 100, (200, 3))

labels = (
    (marks[:, 0] +
     marks[:, 1] +
     marks[:, 2]) / 3 >= 50
).astype(int)

df = pd.DataFrame(
    marks,
    columns=["math", "science", "english"]
)

df["pass"] = labels

# Features and target
X = df[["math", "science", "english"]]
y = df["pass"]

# Train model
model = LogisticRegression()
model.fit(X, y)

# Save model
joblib.dump(model, "student_model.pkl")

print("Model trained successfully!")