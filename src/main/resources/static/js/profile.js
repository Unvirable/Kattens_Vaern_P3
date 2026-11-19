async function loadProfile() {
    try {
        const response = await fetch("/api/profile");

        if (!response.ok) {
            throw new Error("Could not load profile");
        }

        const profile = await response.json();

        // Personal information
        document.getElementById("profileName").textContent = profile.name;
        document.getElementById("profileEmail").textContent = profile.email;
        document.getElementById("profilePhone").textContent = profile.phone;
        document.getElementById("profileAge").textContent = profile.age;
        document.getElementById("profileAddress").textContent = profile.address;

        // Membership information
        if (profile.member) {
            document.getElementById("membershipStatus").textContent = "Aktivt medlem";

            document.getElementById("membershipNumber").textContent =
                profile.membershipNumber;

            document.getElementById("membershipNumberContainer").hidden = false;
        } else {
            document.getElementById("membershipStatus").textContent =
                "Intet aktivt medlemskab";
        }

    } catch (error) {
        console.error("Profile error:", error);

        document.getElementById("profileName").textContent =
            "Kunne ikke indlæse profil";
    }
}

document.addEventListener("DOMContentLoaded", loadProfile);


async function setupLogout() {
    const form = document.getElementById("logoutForm");
    const button = form.querySelector('button[type="submit"]');

    button.disabled = true;

    try {
        const response = await fetch("/api/csrf");

        if (!response.ok) {
            throw new Error("Could not retrieve CSRF token");
        }

        const csrf = await response.json();

        const input = document.createElement("input");
        input.type = "hidden";
        input.name = csrf.parameterName;
        input.value = csrf.token;

        form.appendChild(input);
        button.disabled = false;

    } catch (error) {
        console.error("Logout setup failed:", error);
    }
}

document.addEventListener("DOMContentLoaded", setupLogout);

