import { NavLink } from "react-router-dom";
import "../../styles/sidebar.css";

function Sidebar() {
    return (
        <aside className="sidebar">

            <div className="logo">
                MediSphere
            </div>

            <nav className="menu">

                <NavLink to="/">Dashboard</NavLink>

                <NavLink to="/patients">Patients</NavLink>

                <NavLink to="/predictions">AI Predictions</NavLink>

                <NavLink to="/healthtwin">Health Twin</NavLink>

                <NavLink to="/vitals">Vitals</NavLink>

                <NavLink to="/consent">Consent</NavLink>

                <NavLink to="/fhir">FHIR</NavLink>

            </nav>

        </aside>
    );
}

export default Sidebar;