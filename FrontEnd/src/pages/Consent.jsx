import { useEffect, useState } from "react";
import { getAllConsents } from "../services/consentService";

function Consent() {

    const [consents, setConsents] = useState([]);

    useEffect(() => {
        loadConsents();
    }, []);

    const loadConsents = async () => {
        try {
            const data = await getAllConsents();
            console.log(data);
            setConsents(data);
        } catch (err) {
            console.error(err);
        }
    };

    return (
        <div className="patient-panel">

            <h2>Patient Consents</h2>

            <table className="table">

                <thead>
                <tr>
                    <th>Patient ID</th>
                    <th>Consent Type</th>
                    <th>Status</th>
                    <th>Granted Date</th>
                </tr>
                </thead>

                <tbody>

                {consents.map((consent) => (
                    <tr key={consent.id}>
                        <td>{consent.patientId}</td>
                        <td>{consent.consentType}</td>
                        <td>{consent.status}</td>
                        <td>{consent.grantedDate}</td>
                    </tr>
                ))}

                </tbody>

            </table>

        </div>
    );
}

export default Consent;