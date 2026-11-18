
async function loadNavbar() {
    try {
        // Load the shared navbar HTML
        const response = await fetch("/html/navBar.html");

        if (!response.ok) {
            throw new Error("Could not load navbar");
        }

        const navbar = await response.text();

        document.getElementById("navBar").innerHTML = navbar;

        // Check whether the user is logged in
        const authResponse = await fetch("/api/auth/status");

        if (!authResponse.ok) {
            throw new Error("Could not check login status");
        }

        const authStatus = await authResponse.json();

        // Find the Login link
        const accountLink = document.getElementById("accountNavLink");

        if (authStatus.loggedIn) {
            accountLink.textContent = "Min kat";
            accountLink.href = "myCatPage.html";

            // Show profile icon for logged-in users
            const profileIcon = document.getElementById("profileIcon");

            if (profileIcon) {
                profileIcon.hidden = false;
            }
        }

    } catch (error) {
        console.error("Navbar error:", error);
    }
}
