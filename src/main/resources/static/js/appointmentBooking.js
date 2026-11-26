
const calendar = document.getElementById("calendar");
const timesContainer = document.getElementById("times");
const catId = new URLSearchParams(window.location.search).get("id")



function generateCalendar() {

    calendar.innerHTML = "";

    // Get tomorrow's date
    const startDate = new Date();
    startDate.setDate(startDate.getDate() + 1);

    // Generate the next 14 days
    for (let i = 0; i < 14; i++) {

        const date = new Date(startDate);

        // Add i days
        date.setDate(startDate.getDate() + i);
        if(date.getDay() === 0 || date.getDay() === 6) {
            continue;
        }

        const year = date.getFullYear();
        const month = date.getMonth();
        const day = date.getDate();

        // Format date as YYYY-MM-DD
        const dateString =
            `${year}-${String(month + 1).padStart(2, "0")}-${String(day).padStart(2, "0")}`;

        // Create calendar day
        const button = document.createElement("div");

        button.textContent = date.toLocaleDateString("en", {
            weekday: "short",
            day: "numeric",
            month: "short"
        });

        button.classList.add("day");

        button.addEventListener("click", () => {

            showAvailableTimes(dateString);

            document.querySelectorAll(".day")
                .forEach(d => d.classList.remove("selected"));

            button.classList.add("selected");
        });

        calendar.appendChild(button);
    }
}

async function showAvailableTimes(date) {
    timesContainer.innerHTML = "";

    try {
        const response = await fetch(`/api/getTimeslotsForCat?catId=${catId}&date=${date}`);
        if (!response.ok) {
            throw new Error("Failed to fetch times");
        }
        const slots = await response.json();

        if (slots.length === 0) {
            timesContainer.textContent = "Ingen ledige tider denne dag.";
            return;
        }

        slots.forEach(slot => {
            const button = document.createElement("button");
            button.textContent = slot.label;
            button.addEventListener("click", () => {
                const confirmed = confirm(`Vil du bekræfte denne booking? ${slot.label} ${date}`);
                if (confirmed){
                    bookAppointment(date, slot.slot)
                }
            });
            timesContainer.appendChild(button);
        });
    } catch (error) {
        console.error("error", error);
    }
}

async function bookAppointment(date, slot) {
    const csrfResponse = await fetch("/api/csrf")

    if(!csrfResponse.ok){
        alert("Booking kunne ikke oprettes prøv igen")
        return;
    }

    const csrf = await csrfResponse.json();

    const response = await fetch("/api/createAppointment", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            [csrf.headerName || "X-CSRF-TOKEN"]: csrf.token
        },
        body: JSON.stringify({ catId: Number(catId), date: date, slot: slot })
    });

    if (response.redirected) {
        window.location.href = "loginPage.html";
        return;
    }
    if (!response.ok) {
        alert("Booking kunne ikke oprettes. Prøv en anden dag eller tid.");
        return;
    }

    alert("Din booking er oprettet!");
    await showAvailableTimes(date);
}

    generateCalendar();
