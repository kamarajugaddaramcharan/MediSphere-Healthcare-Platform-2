import api from "./api";

export const getAllVitals = async () => {
    const response = await api.get("/vitals");
    return response.data;
};

export const getVitalById = async (id) => {
    const response = await api.get(`/vitals/${id}`);
    return response.data;
};

export const createVital = async (vital) => {
    const response = await api.post("/vitals", vital);
    return response.data;
};

export const updateVital = async (id, vital) => {
    const response = await api.put(`/vitals/${id}`, vital);
    return response.data;
};

export const deleteVital = async (id) => {
    await api.delete(`/vitals/${id}`);
};