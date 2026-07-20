import {
    Line
} from "react-chartjs-2";

import {
    Chart as ChartJS,
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    Title,
    Tooltip,
    Legend
} from "chart.js";

ChartJS.register(
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    Title,
    Tooltip,
    Legend
);

function VitalsChart({ vitals }) {

    const data = {
        labels: vitals.map((v, index) => index + 1),
        datasets: [
            {
                label: "Heart Rate",
                data: vitals.map(v => v.heartRate),
                borderColor: "#2563eb",
                backgroundColor: "rgba(37,99,235,.2)",
                tension: 0.4
            }
        ]
    };

    const options = {
        responsive: true,
        plugins: {
            legend: {
                position: "top"
            }
        }
    };

    return (
        <div className="card">
            <h2>Heart Rate Trend</h2>

            <Line
                data={data}
                options={options}
            />
        </div>
    );
}

export default VitalsChart;