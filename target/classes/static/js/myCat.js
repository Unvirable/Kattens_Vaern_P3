
async function loadMyCats() {
    const container = document.getElementById("myCatsContainer");
    const noCatsMessage = document.getElementById("noCatsMessage");

    try {
        const response = await fetch("/api/mycats");

        // Redirect visitors who are not logged in
        if (response.redirected && response.url.includes("/login")) {
            window.location.replace("/html/loginPage.html");
            return;
        }

        if (!response.ok) {
            throw new Error("Could not retrieve adopted cats");
        }

        const cats = await response.json();

        // Remove the loading message
        container.innerHTML = "";

        // User has no adopted cats
        if (cats.length === 0) {
            noCatsMessage.hidden = false;
            return;
        }

        // Create an HTML section for each adopted cat
        cats.forEach(async (cat) => {
            const catSection = document.createElement("section");

            const heading = document.createElement("h2");
            heading.textContent = cat.name;

            const birthday = document.createElement("p");
            birthday.textContent = "Fødselsdato: " + cat.birthday;

            const location = document.createElement("p");
            location.textContent = "Internat: " + cat.locatedIn;

            const description = document.createElement("p");
            description.textContent = cat.description;

            catSection.appendChild(heading);
            catSection.appendChild(birthday);
            catSection.appendChild(location);
            catSection.appendChild(description);

            const medicalHeading = document.createElement("h3");
            medicalHeading.textContent = "Sundhedsjournal";
            catSection.appendChild(medicalHeading);

            const medicalContainer = document.createElement("div");
            medicalContainer.textContent = "Indlæser sundhedsoplysninger...";
            catSection.appendChild(medicalContainer);

            try {
                const medicalResponse = await fetch(
                    `/api/mycats/${cat.id}/medical-records`
                );

                if (!medicalResponse.ok) {
                    throw new Error("Could not retrieve medical records");
                }

                const records = await medicalResponse.json();

                medicalContainer.textContent = "";

                if (records.length === 0) {
                    medicalContainer.textContent =
                        "Ingen sundhedsoplysninger registreret.";
                } else {
                    records.forEach(record => {
                        const recordSection = document.createElement("div");

                        const type = document.createElement("p");
                        type.textContent = "Type: " + record.recordType;

                        const description = document.createElement("p");
                        description.textContent = record.description;

                        const nextDate = document.createElement("p");
                        nextDate.textContent =
                            "Næste dato: " + record.nextDueDate;

                        recordSection.appendChild(type);
                        recordSection.appendChild(description);
                        recordSection.appendChild(nextDate);

                        medicalContainer.appendChild(recordSection);
                    });
                }

            } catch (error) {
                console.error("Medical records error:", error);

                medicalContainer.textContent =
                    "Kunne ikke indlæse sundhedsoplysninger.";
            }

            container.appendChild(catSection);
        });

    } catch (error) {
        console.error("My Cat error:", error);
        container.textContent = "Kunne ikke indlæse dine katte.";
    }
}

document.addEventListener("DOMContentLoaded", loadMyCats);
