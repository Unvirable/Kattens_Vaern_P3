
async function setupLoginForm() {

        
    const authResponse = await fetch("/api/auth/status");

    if (authResponse.ok) {
        const authStatus = await authResponse.json();

        if (authStatus.loggedIn) {
            window.location.replace("/html/newsPage.html");
            return;
        }
    }

    const form = document.querySelector("#loginForm");
    const submitButton = form.querySelector('button[type="submit"]');

    // Prevent submitting before the CSRF token is ready
    submitButton.disabled = true;

    try {
        const response = await fetch("/api/csrf");

        if (!response.ok) {
            throw new Error("Could not retrieve CSRF token");
        }

        const csrf = await response.json();

        // Add the CSRF token as a hidden form field
        const input = document.createElement("input");
        input.type = "hidden";
        input.name = csrf.parameterName;
        input.value = csrf.token;

        form.appendChild(input);
        submitButton.disabled = false;

    } catch (error) {
        console.error("Login initialization failed:", error);
    }
}

document.addEventListener("DOMContentLoaded", setupLoginForm);
