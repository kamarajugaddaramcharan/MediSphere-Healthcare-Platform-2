import DashboardHeader from "../components/patient360/DashboardHeader";
import PatientProfileCard from "../components/patient360/PatientProfileCard";
import PatientTabs from "../components/patient360/PatientTabs";
import HealthTwinCard from "../components/patient360/HealthTwinCard";
import KeyVitalsCard from "../components/patient360/KeyVitalsCard";
import HealthScoreCard from "../components/patient360/HealthScoreCard";
import SummaryCards from "../components/patient360/SummaryCards";

import "../styles/patient360.css";

function Patient360() {

    return (

        <div className="patient360">

            <DashboardHeader />

            <PatientProfileCard />

            <PatientTabs />

            <div className="patient-grid">

                <HealthTwinCard />

                <KeyVitalsCard />

                <HealthScoreCard />

            </div>

            <SummaryCards />

        </div>

    );

}

export default Patient360;