function PatientOverview({ patients }) {

    if (patients.length === 0) {
        return (
            <div className="card">
                <h2>Patient Overview</h2>
                <p>No Patient Found</p>
            </div>
        );
    }

    const patient = patients[0];

    return (
        <div className="card">

            <h2>👤 Patient Overview</h2>

            <div className="patient-grid">

                <div>
                    <strong>Name</strong>
                    <p>{patient.name}</p>
                </div>

                <div>
                    <strong>Age</strong>
                    <p>{patient.age}</p>
                </div>

                <div>
                    <strong>Disease</strong>
                    <p>{patient.disease}</p>
                </div>

                <div>
                    <strong>Patient ID</strong>
                    <p>{patient.id}</p>
                </div>

            </div>

        </div>
    );
}

export default PatientOverview;