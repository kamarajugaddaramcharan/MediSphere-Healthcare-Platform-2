import api from "./api";

export const getAllConsents = async () => {
    const response = await api.get("/consents");
    return response.data;
};

export const getConsentById = async (id) => {
    const response = await api.get(`/consents/${id}`);
    return response.data;
};

export const createConsent = async (consent) => {
    const response = await api.post("/consents", consent);
    return response.data;
};

export const updateConsent = async (id, consent) => {
    const response = await api.put(`/consents/${id}`, consent);
    return response.data;
};

export const deleteConsent = async (id) => {
    await api.delete(`/consents/${id}`);
};