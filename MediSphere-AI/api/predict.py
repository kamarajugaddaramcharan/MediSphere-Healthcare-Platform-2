import numpy as np
import tensorflow as tf
from config import MODEL_PATH, THRESHOLD

model = tf.keras.models.load_model(MODEL_PATH)


def predict(features):
    features = np.array(features, dtype=np.float32).reshape(1, -1)

    probability = float(model.predict(features, verbose=0)[0][0])

    prediction = 1 if probability >= THRESHOLD else 0

    return {
        "prediction": prediction,
        "probability": probability
    }