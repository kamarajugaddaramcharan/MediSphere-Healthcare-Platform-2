import { User, Calendar, Droplets, Heart } from "lucide-react";

function PatientProfileCard({ patient }) {

    if (!patient) {
        return (
            <div className="patient-profile-card">
                Loading patient...
            </div>
        );
    }

    const initials = patient?.name
        ? patient.name
            .split(" ")
            .map(word => word[0])
            .join("")
            .toUpperCase()
        : "PT";

    return (

        <div className="patient-profile-card">

            <div className="profile-left">

                <div className="patient-avatar-placeholder">
                    {initials}
                </div>

                <div>

                    <h2>{patient.name}</h2>

                    <p>
                        Patient ID : {patient.patientId}
                    </p>

                    <span className="status-badge">
                        Active Patient
                    </span>

                </div>

            </div>

            <div className="profile-right">

                <div className="info-box">

                    <User size={20} />

                    <div>
                        <small>Age</small>
                        <strong>{patient.age} Years</strong>
                    </div>

                </div>

                <div className="info-box">

                    <Droplets size={20} />

                    <div>
                        <small>Blood Group</small>
                        <strong>{patient.bloodGroup}</strong>
                    </div>

                </div>

                <div className="info-box">

                    <Heart size={20} />

                    <div>
                        <small>Gender</small>
                        <strong>{patient.gender}</strong>
                    </div>

                </div>

                <div className="info-box">

                    <Calendar size={20} />

                    <div>
                        <small>Last Visit</small>
                        <strong>{patient.lastVisit}</strong>
                    </div>

                </div>

            </div>

        </div>

    );

}

export default PatientProfileCard;