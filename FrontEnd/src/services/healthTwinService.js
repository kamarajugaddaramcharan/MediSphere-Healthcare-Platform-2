import api from "./api";

export const getAllHealthTwins = async () => {
    const response = await api.get("/healthtwins");
    return response.data;
};

export const getHealthTwinById = async (id) => {
    const response = await api.get(`/healthtwins/${id}`);
    return response.data;
};

export const createHealthTwin = async (healthTwin) => {
    const response = await api.post("/healthtwins", healthTwin);
    return response.data;
};

export const updateHealthTwin = async (id, healthTwin) => {
    const response = await api.put(`/healthtwins/${id}`, healthTwin);
    return response.data;
};

export const deleteHealthTwin = async (id) => {
    await api.delete(`/healthtwins/${id}`);
};