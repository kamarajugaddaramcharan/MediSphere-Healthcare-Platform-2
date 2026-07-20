function FHIRCard({ records }) {

    if (records.length === 0) return null;

    const record = records[0];

    return (
        <div className="card">

            <h2>📄 FHIR Resource</h2>

            <div className="patient-grid">

                <div>
                    <strong>Patient ID</strong>
                    <p>{record.patientId}</p>
                </div>

                <div>
                    <strong>Resource Type</strong>
                    <p>{record.resourceType}</p>
                </div>

                <div>
                    <strong>Created</strong>
                    <p>{record.createdAt}</p>
                </div>

                <div>
                    <strong>Data</strong>
                    <p>{record.resourceData}</p>
                </div>

            </div>

        </div>
    );
}

export default FHIRCard;