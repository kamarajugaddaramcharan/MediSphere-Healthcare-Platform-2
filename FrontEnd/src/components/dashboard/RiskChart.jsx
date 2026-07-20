import {
    PieChart,
    Pie,
    Cell,
    Tooltip,
    Legend,
    ResponsiveContainer,
} from "recharts";

const data = [
    { name: "High Risk", value: 120 },
    { name: "Moderate", value: 80 },
    { name: "Low Risk", value: 106 },
];

const COLORS = ["#ef4444", "#f59e0b", "#22c55e"];

function RiskChart() {
    return (
        <div
            style={{
                background: "#fff",
                borderRadius: 18,
                padding: 20,
                boxShadow: "0 10px 30px rgba(0,0,0,.08)",
            }}
        >
            <h3>AI Risk Distribution</h3>

            <ResponsiveContainer width="100%" height={300}>
                <PieChart>
                    <Pie
                        data={data}
                        dataKey="value"
                        outerRadius={100}
                        label
                    >
                        {data.map((entry, index) => (
                            <Cell
                                key={index}
                                fill={COLORS[index]}
                            />
                        ))}
                    </Pie>

                    <Tooltip />
                    <Legend />
                </PieChart>
            </ResponsiveContainer>
        </div>
    );
}

export default RiskChart;