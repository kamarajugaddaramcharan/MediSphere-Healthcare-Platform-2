import { useEffect, useState } from "react";
import { getAllFHIR } from "../services/fhirService";

function FHIR() {

    const [records, setRecords] = useState([]);

    useEffect(() => {
        loadFHIR();
    }, []);

    const loadFHIR = async () => {
        try {
            const data = await getAllFHIR();
            console.log(data);
            setRecords(data);
        } catch (err) {
            console.error(err);
        }
    };

    return (
        <div className="patient-panel">

            <h2>FHIR Records</h2>

            <table className="table">

                <thead>
                <tr>
                    <th>Patient ID</th>
                    <th>Resource Type</th>
                    <th>Resource ID</th>
                    <th>Last Updated</th>
                </tr>
                </thead>

                <tbody>

                {records.map((record) => (
                    <tr key={record.id}>
                        <td>{record.patientId}</td>
                        <td>{record.resourceType}</td>
                        <td>{record.resourceId}</td>
                        <td>{record.lastUpdated}</td>
                    </tr>
                ))}

                </tbody>

            </table>

        </div>
    );
}

export default FHIR;