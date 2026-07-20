import api from "./api";

export const getDashboardData = async () => {

    const [patients, healthTwins, predictions] = await Promise.all([
        api.get("/patients"),
        api.get("/healthtwins"),
        api.get("/api/prediction"),
    ]);

    return {
        patients: patients.data.length,
        healthTwins: healthTwins.data.length,
        predictions: predictions.data.length,
    };
};