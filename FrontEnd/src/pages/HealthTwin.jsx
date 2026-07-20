import { useEffect, useState } from "react";
import { getAllHealthTwins } from "../services/healthTwinService";

function HealthTwin() {
    const [twins, setTwins] = useState([]);

    const loadHealthTwins = async () => {
        try {
            const data = await getAllHealthTwins();
            console.log(data);
            setTwins(data);
        } catch (err) {
            console.error(err);
        }
    };

    useEffect(() => {
        loadHealthTwins();
    }, []);

    return (
        <div className="patient-panel">
            <h2>Health Twins</h2>

            <table className="table">
                <thead>
                <tr>
                    <th>Patient</th>
                    <th>Blood Group</th>
                    <th>Height</th>
                    <th>Weight</th>
                    <th>Heart Rate</th>
                    <th>Blood Pressure</th>
                    <th>Status</th>
                </tr>
                </thead>

                <tbody>
                {twins.map((twin) => (
                    <tr key={twin.id}>
                        <td>{twin.patientId}</td>
                        <td>{twin.bloodGroup}</td>
                        <td>{twin.height}</td>
                        <td>{twin.weight}</td>
                        <td>{twin.heartRate}</td>
                        <td>{twin.bloodPressure}</td>
                        <td>{twin.status}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

export default HealthTwin;