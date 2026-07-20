import api from "./api";

export const getAllPredictions = async () => {
    const response = await api.get("/api/prediction");
    return response.data;
};

export const getPredictionById = async (id) => {
    const response = await api.get(`/api/prediction/${id}`);
    return response.data;
};

export const createPrediction = async (prediction) => {
    const response = await api.post("/api/prediction/cvd", prediction);
    return response.data;
};

export const deletePrediction = async (id) => {
    await api.delete(`/api/prediction/${id}`);
};