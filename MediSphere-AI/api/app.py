from flask import Flask, request, jsonify
from predict import predict

app = Flask(__name__)


@app.route("/")
def home():
    return jsonify({
        "message": "Heart Disease Prediction API Running"
    })


@app.route("/predict", methods=["POST"])
def predict_api():
    data = request.get_json()

    if "features" not in data:
        return jsonify({
            "error": "Missing features"
        }), 400

    result = predict(data["features"])

    return jsonify(result)


if __name__ == "__main__":
    app.run(
        host="0.0.0.0",
        port=5000,
        debug=True
    )