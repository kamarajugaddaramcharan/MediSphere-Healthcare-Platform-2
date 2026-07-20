function HealthTwinCard({ twins }) {

    if (twins.length === 0) {
        return (
            <div className="card">
                <h2>Digital Health Twin</h2>
                <p>No Health Twin Data</p>
            </div>
        );
    }

    const twin = twins[0];

    return (
        <div className="card">

            <h2>🫀 Digital Health Twin</h2>

            <div className="patient-grid">

                <div>
                    <strong>Blood Group</strong>
                    <p>{twin.bloodGroup}</p>
                </div>

                <div>
                    <strong>Height</strong>
                    <p>{twin.height} cm</p>
                </div>

                <div>
                    <strong>Weight</strong>
                    <p>{twin.weight} kg</p>
                </div>

                <div>
                    <strong>Heart Rate</strong>
                    <p>{twin.heartRate} bpm</p>
                </div>

                <div>
                    <strong>Blood Pressure</strong>
                    <p>{twin.bloodPressure}</p>
                </div>

                <div>
                    <strong>Status</strong>

                    <span
                        style={{
                            background: "#22c55e",
                            color: "white",
                            padding: "6px 14px",
                            borderRadius: "20px",
                            fontWeight: "bold"
                        }}
                    >
                        {twin.status}
                    </span>

                </div>

            </div>

        </div>
    );
}

export default HealthTwinCard;