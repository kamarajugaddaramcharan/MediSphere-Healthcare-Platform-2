function ConsentCard({ consents }) {

    if (consents.length === 0) return null;

    const consent = consents[0];

    return (
        <div className="card">

            <h2>🔒 Consent Information</h2>

            <div className="patient-grid">

                <div>
                    <strong>Doctor</strong>
                    <p>{consent.doctorId}</p>
                </div>

                <div>
                    <strong>Resource</strong>
                    <p>{consent.resourceType}</p>
                </div>

                <div>
                    <strong>Permission</strong>
                    <p>{consent.permission}</p>
                </div>

                <div>
                    <strong>Status</strong>
                    <p>{consent.status}</p>
                </div>

            </div>

        </div>
    );
}

export default ConsentCard;