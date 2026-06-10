from flask import Flask, request, jsonify
import joblib
import numpy as np

app = Flask(__name__)

model = joblib.load("student_model.pkl")

@app.route("/predict", methods=["POST"])
def predict():

    data = request.json

    features = np.array([
        [
            data["math"],
            data["science"],
            data["english"]
        ]
    ])

    prediction = int(model.predict(features)[0])

    confidence = float(
        max(model.predict_proba(features)[0])
    )

    return jsonify({
        "prediction": prediction,
        "confidence": round(confidence, 2)
    })

if __name__ == "__main__":
    app.run(debug=True, port=5000)