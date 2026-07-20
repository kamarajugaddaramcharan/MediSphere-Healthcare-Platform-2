import { useEffect, useState } from "react";
import { getAllVitals } from "../services/vitalService";

function Vitals() {
    const [vitals, setVitals] = useState([]);

    const loadVitals = async () => {
        try {
            const data = await getAllVitals();
            console.log("Vitals:", data);
            setVitals(data);
        } catch (err) {
            console.error(err);
        }
    };

    useEffect(() => {
        loadVitals();
    }, []);

    return (
        <div className="patient-panel">

            <h2>Patient Vitals</h2>

            <table className="table">

                <thead>
                <tr>
                    <th>Patient ID</th>
                    <th>Heart Rate</th>
                    <th>Blood Pressure</th>
                    <th>Temperature</th>
                    <th>Oxygen Level</th>
                </tr>
                </thead>

                <tbody>
                {vitals.map((vital) => (
                    <tr key={vital.id}>
                        <td>{vital.patientId}</td>
                        <td>{vital.heartRate}</td>
                        <td>{vital.bloodPressure}</td>
                        <td>{vital.temperature}</td>
                        <td>{vital.oxygenLevel}</td>
                    </tr>
                ))}
                </tbody>

            </table>

        </div>
    );
}

export default Vitals;