import { useEffect, useState } from "react";
import { getAllPatients } from "../../services/patientService";

function RecentPatients() {
    const [patients, setPatients] = useState([]);

    useEffect(() => {
        loadPatients();
    }, []);

    const loadPatients = async () => {
        try {
            const data = await getAllPatients();

            // Show only first 5 patients
            setPatients(data.slice(0, 5));
        } catch (err) {
            console.error(err);
        }
    };

    return (
        <div
            style={{
                background: "#fff",
                padding: 20,
                borderRadius: 18,
                boxShadow: "0 10px 30px rgba(0,0,0,.08)",
            }}
        >
            <h2>Recent Patients</h2>

            <table
                style={{
                    width: "100%",
                    borderCollapse: "collapse",
                }}
            >
                <thead>
                <tr>
                    <th align="left">ID</th>
                    <th align="left">Name</th>
                    <th align="left">Age</th>
                    <th align="left">Gender</th>
                </tr>
                </thead>

                <tbody>
                {patients.map((patient) => (
                    <tr key={patient.id}>
                        <td>{patient.id}</td>
                        <td>{patient.name}</td>
                        <td>{patient.age}</td>
                        <td>{patient.gender}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

export default RecentPatients;