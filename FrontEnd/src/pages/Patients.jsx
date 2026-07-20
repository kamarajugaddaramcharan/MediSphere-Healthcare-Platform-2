import { useEffect, useState } from "react";
import { getAllPatients } from "../services/patientService";

function Patients() {

    const [patients, setPatients] = useState([]);

    const loadPatients = async () => {
        try {
            const data = await getAllPatients();
            console.log(data);
            setPatients(data);
        } catch (error) {
            console.error(error);
        }
    };

    useEffect(() => {
        loadPatients();
    }, []);

    return (
        <div className="patient-panel">

            <h2>Patients</h2>

            <table className="table">

                <thead>
                <tr>
                    <th>Patient ID</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Medical Condition</th>
                    <th>Treatment</th>
                    <th>Outcome</th>
                </tr>
                </thead>

                <tbody>
                {patients.map((patient) => (
                    <tr key={patient.id}>
                        <td>{patient.patientId}</td>
                        <td>{patient.age}</td>
                        <td>{patient.gender}</td>
                        <td>{patient.medicalCondition}</td>
                        <td>{patient.treatment}</td>
                        <td>{patient.outcome}</td>
                    </tr>
                ))}
                </tbody>

            </table>

        </div>
    );
}

export default Patients;