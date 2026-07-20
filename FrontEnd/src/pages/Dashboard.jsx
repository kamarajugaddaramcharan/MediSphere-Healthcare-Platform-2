import { useEffect, useState } from "react";

import { getDashboardData } from "../services/dashboardService";
import { getAllPatients } from "../services/patientService";

import DashboardHeader from "../components/dashboard/DashboardHeader";
import PatientProfileCard from "../components/dashboard/PatientProfileCard";
import SummaryCard from "../components/dashboard/SummaryCard";
import RiskChart from "../components/dashboard/RiskChart";
import PatientGrowthChart from "../components/dashboard/PatientGrowthChart";
import HeartRateChart from "../components/dashboard/HeartRateChart";
import RecentPatients from "../components/dashboard/RecentPatients";

import "../styles/dashboard.css";

function Dashboard() {

    const [stats, setStats] = useState({
        patients: 0,
        healthTwins: 0,
        predictions: 0,
    });

    const [selectedPatient, setSelectedPatient] = useState(null);

    useEffect(() => {

        loadDashboard();
        loadPatient();

    }, []);

    const loadDashboard = async () => {

        try {

            const data = await getDashboardData();

            setStats({
                patients: data.patients,
                healthTwins: data.healthTwins,
                predictions: data.predictions,
            });

        } catch (err) {

            console.error(err);

        }

    };

    const loadPatient = async () => {

        try {

            const patients = await getAllPatients();

            if (patients && patients.length > 0) {

                setSelectedPatient(patients[0]);

            }

        } catch (err) {

            console.error(err);

        }

    };

    return (

        <div className="dashboard-container">

            {/* Header */}

            <DashboardHeader />

            {/* Patient Profile */}

            <PatientProfileCard patient={selectedPatient} />

            {/* Summary Cards */}

            <div className="dashboard-grid">

                <SummaryCard
                    title="Patients"
                    value={stats.patients}
                    color="#2563eb"
                />

                <SummaryCard
                    title="Health Twins"
                    value={stats.healthTwins}
                    color="#10b981"
                />

                <SummaryCard
                    title="AI Predictions"
                    value={stats.predictions}
                    color="#ef4444"
                />

                <SummaryCard
                    title="System Status"
                    value="ONLINE"
                    color="#16a34a"
                />

            </div>

            {/* Charts */}

            <div className="charts-grid">

                <RiskChart />

                <PatientGrowthChart />

                <HeartRateChart />

            </div>

            {/* Bottom Section */}

            <div className="bottom-grid">

                <div className="dashboard-card">

                    <h2>System Overview</h2>

                    <ul>
                        <li>✅ API Gateway Connected</li>
                        <li>✅ MongoDB Connected</li>
                        <li>✅ Patient Service Online</li>
                        <li>✅ Health Twin Service Online</li>
                        <li>✅ AI Prediction Service Online</li>
                        <li>✅ Consent Service Online</li>
                        <li>✅ FHIR Service Online</li>
                    </ul>

                </div>

                <RecentPatients />

            </div>

        </div>

    );

}

export default Dashboard;