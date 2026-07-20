function DashboardCard({ title, value, subtitle }) {
    return (
        <div className="dashboard-card">
            <h4>{title}</h4>

            <h2>{value}</h2>

            <small>{subtitle}</small>
        </div>
    );
}

export default DashboardCard;