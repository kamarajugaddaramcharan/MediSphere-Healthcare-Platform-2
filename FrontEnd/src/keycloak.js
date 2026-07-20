import Keycloak from "keycloak-js";

const keycloak = new Keycloak({
    url: "http://localhost:8080",
    realm: "MediSphere",
    clientId: "medisphere-frontend",
});

export default keycloak;