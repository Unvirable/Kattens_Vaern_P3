async function loadNews() {
    try {
        const response = await fetch("/api/news");

        if (!response.ok) {
            throw new Error("Kunne ikke hente nyheder");
        }

        const news = await response.json();
        const container = document.getElementById("newsContainer");

        container.innerHTML = "";

        if (news.length === 0) {
            container.textContent = "Der er endnu ingen nyheder.";
            return;
        }

        news.forEach(article => {
            const articleElement = document.createElement("div");
            articleElement.classList.add("newsArticle");

            // Billede
            if (article.imageUrl) {
                const image = document.createElement("img");
                image.src = article.imageUrl;
                image.alt = article.title;
                image.classList.add("newsImage");
                articleElement.appendChild(image);
            }

            // Overskrift
            const title = document.createElement("h2");
            title.textContent = article.title;
            
            // Dato
            const date = document.createElement("p");
            date.textContent = article.date;
            date.classList.add("newsDate");

            // Kort introduktion
            const content = document.createElement("p");
            const fullText = article.content;
            const shortText = fullText.length > 150
                ? fullText.substring(0, 150) + "..."
                : fullText;

            content.textContent = shortText;

            articleElement.appendChild(title);
            articleElement.appendChild(date);
            articleElement.appendChild(content);

            // Læs mere-knap
            if (fullText.length > 150) {
                const readMoreButton = document.createElement("button");
                readMoreButton.textContent = "Læs mere";

                readMoreButton.addEventListener("click", () => {
                    const isExpanded = readMoreButton.textContent === "Læs mindre";

                    content.textContent = isExpanded ? shortText : fullText;
                    readMoreButton.textContent = isExpanded ? "Læs mere" : "Læs mindre";
                });

                articleElement.appendChild(readMoreButton);
            }

            container.appendChild(articleElement);
        });

    } catch (error) {
        console.error("Fejl ved hentning af nyheder:", error);
    }
} //Billederne vises først, når der er gemt billedadresser i databasen btw. 
// Den henter alle nyheder fra databasen og viser deres overskrift, dato og tekst på hjemmesiden.