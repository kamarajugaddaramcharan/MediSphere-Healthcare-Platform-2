import {
    ResponsiveContainer,
    LineChart,
    Line,
    CartesianGrid,
    XAxis,
    YAxis,
    Tooltip,
} from "recharts";

const data = [
    { month: "Jan", patients: 120 },
    { month: "Feb", patients: 180 },
    { month: "Mar", patients: 260 },
    { month: "Apr", patients: 340 },
    { month: "May", patients: 470 },
    { month: "Jun", patients: 610 },
];

function PatientGrowthChart() {
    return (
        <div
            style={{
                background: "#fff",
                padding: 20,
                borderRadius: 18,
                boxShadow: "0 10px 30px rgba(0,0,0,.08)",
            }}
        >
            <h3>Patient Growth</h3>

            <ResponsiveContainer width="100%" height={300}>
                <LineChart data={data}>
                    <CartesianGrid strokeDasharray="3 3" />
                    <XAxis dataKey="month" />
                    <YAxis />
                    <Tooltip />

                    <Line
                        type="monotone"
                        dataKey="patients"
                        stroke="#2563eb"
                        strokeWidth={3}
                    />
                </LineChart>
            </ResponsiveContainer>
        </div>
    );
}

export default PatientGrowthChart;