function Navbar() {

    return (

        <header
            style={{
                height:80,
                background:"white",
                display:"flex",
                justifyContent:"space-between",
                alignItems:"center",
                padding:"0 35px",
                boxShadow:"0 5px 15px rgba(0,0,0,.05)"
            }}
        >

            <div>

                <h2>MediSphere Healthcare Platform</h2>

                <small>Patient 360 Dashboard</small>

            </div>

            <button
                style={{
                    background:"#2563eb",
                    color:"white",
                    padding:"12px 25px",
                    borderRadius:12
                }}
            >
                Clinician
            </button>

        </header>

    );

}

export default Navbar;