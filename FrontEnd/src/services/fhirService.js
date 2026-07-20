import api from "./api";

export const getAllFHIR = async () => {
    const response = await api.get("/fhir");
    return response.data;
};

export const getFHIRById = async (id) => {
    const response = await api.get(`/fhir/${id}`);
    return response.data;
};

export const createFHIR = async (record) => {
    const response = await api.post("/fhir", record);
    return response.data;
};

export const updateFHIR = async (id, record) => {
    const response = await api.put(`/fhir/${id}`, record);
    return response.data;
};

export const deleteFHIR = async (id) => {
    await api.delete(`/fhir/${id}`);
};