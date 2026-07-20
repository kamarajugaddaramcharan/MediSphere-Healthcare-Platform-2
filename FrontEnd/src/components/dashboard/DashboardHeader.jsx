import { Bell, Mail, Search } from "lucide-react";

function DashboardHeader() {
    return (
        <div className="dashboard-header">

            <div>

                <h1>Patient 360 Dashboard</h1>

                <p>Complete patient overview and digital health twin</p>

            </div>

            <div className="header-right">

                <div className="search-box">

                    <Search size={18} />

                    <input
                        type="text"
                        placeholder="Search patients..."
                    />

                </div>

                <button className="icon-btn">
                    <Bell size={18} />
                </button>

                <button className="icon-btn">
                    <Mail size={18} />
                </button>

                <div className="doctor">

                    <img
                        src="https://i.pravatar.cc/100?img=32"
                        alt="doctor"
                    />

                    <div>

                        <strong>Dr. Sarah Wilson</strong>

                        <small>Cardiologist</small>

                    </div>

                </div>

            </div>

        </div>
    );
}

export default DashboardHeader;