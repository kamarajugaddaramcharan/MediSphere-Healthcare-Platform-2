import { BrowserRouter, Routes, Route } from "react-router-dom";

import Layout from "./components/layout/Layout";

import Dashboard from "./pages/Dashboard";
import Patient360 from "./pages/Patient360";
import Patients from "./pages/Patients";
import Vitals from "./pages/Vitals";
import HealthTwin from "./pages/HealthTwin";
import Consent from "./pages/Consent";
import FHIR from "./pages/FHIR";
import AIPredictions from "./pages/AIPredictions";

function App() {
    return (
        <BrowserRouter>
            <Layout>
                <Routes>

                    {/* Dashboard */}
                    <Route path="/" element={<Dashboard />} />

                    {/* Patient 360 */}
                    <Route path="/patient360" element={<Patient360 />} />

                    {/* Existing Pages */}
                    <Route path="/patients" element={<Patients />} />

                    <Route path="/healthtwin" element={<HealthTwin />} />

                    <Route path="/vitals" element={<Vitals />} />

                    <Route path="/consent" element={<Consent />} />

                    <Route path="/fhir" element={<FHIR />} />

                    <Route path="/predictions" element={<AIPredictions />} />

                </Routes>
            </Layout>
        </BrowserRouter>
    );
}

export default App;