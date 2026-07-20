import "./AIPredictionCard.css";

function AIPredictionCard({ predictions }) {

    return (
        <div className="prediction-card">

            <h2>AI Prediction Results</h2>

            <table className="prediction-table">

                <thead>
                <tr>
                    <th>Patient ID</th>
                    <th>Age</th>
                    <th>Risk Level</th>
                    <th>Risk %</th>
                    <th>Confidence</th>
                </tr>
                </thead>

                <tbody>

                {predictions.slice(0, 10).map((prediction) => (

                    <tr key={prediction.id}>

                        <td>{prediction.patientId}</td>
                        <td>{prediction.age}</td>
                        <td>{prediction.riskLevel}</td>
                        <td>{prediction.riskPercentage}%</td>
                        <td>{prediction.confidence}%</td>

                    </tr>

                ))}

                </tbody>

            </table>

        </div>
    );
}

export default AIPredictionCard;