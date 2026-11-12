async function loadNews() {
    try {
        const response = await fetch("http://localhost:8080/api/news");

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

            const title = document.createElement("h2");
            title.textContent = article.title;

            const date = document.createElement("p");
            date.textContent = article.date;

            const content = document.createElement("p");
            content.textContent = article.content;

            articleElement.appendChild(title);
            articleElement.appendChild(date);
            articleElement.appendChild(content);

            container.appendChild(articleElement);
        });

    } catch (error) {
        console.error("Fejl ved hentning af nyheder:", error);
    }
} // Den henter alle nyheder fra databasen og viser deres overskrift, dato og tekst på hjemmesiden.