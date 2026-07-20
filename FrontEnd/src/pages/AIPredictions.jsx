import { useEffect, useState } from "react";
import { getAllPredictions } from "../services/predictionService";

function AIPredictions() {

    const [predictions, setPredictions] = useState([]);

    useEffect(() => {
        loadPredictions();
    }, []);

    const loadPredictions = async () => {
        try {
            const data = await getAllPredictions();
            console.log(data);
            setPredictions(data);
        } catch (err) {
            console.error(err);
        }
    };

    return (
        <div className="patient-panel">

            <h2>AI Predictions</h2>

            <table className="table">

                <thead>
                <tr>
                    <th>Patient ID</th>
                    <th>Risk %</th>
                    <th>Risk Level</th>
                    <th>Confidence</th>
                    <th>Prediction Date</th>
                </tr>
                </thead>

                <tbody>

                {predictions.map((prediction) => (
                    <tr key={prediction.id}>
                        <td>{prediction.patientId}</td>
                        <td>{prediction.riskPercentage}%</td>
                        <td>{prediction.riskLevel}</td>
                        <td>{prediction.confidence}%</td>
                        <td>{prediction.predictionDate}</td>
                    </tr>
                ))}

                </tbody>

            </table>

        </div>
    );
}

export default AIPredictions;