import "./SummaryCard.css";

function SummaryCard({ title, value, color }) {
    return (
        <div className="summary-card">
            <h4>{title}</h4>

            <h1 style={{ color }}>{value}</h1>
        </div>
    );
}

export default SummaryCard;