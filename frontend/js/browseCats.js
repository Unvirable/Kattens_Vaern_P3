async function getCats(){
    try {
        const response = await fetch("http://localhost:8080/api/getCats")

        if (!response.ok) {
            throw new Error("Failed to fetch cats")
        }

        const cats = await response.json()

        const container = document.getElementById("catContainer");

        cats.forEach(cat =>{
            const catElement = document.createElement("div");
            catElement.classList.add("cat");

            const name = document.createElement("h2");
            name.textContent = "Name: " + cat.name;

            const age = document.createElement("h2")
            age.textContent = "Age: " + cat.age;

            const city = document.createElement("h2");
            city.textContent = "Located in: " + cat.city;

            const description = document.createElement("h2");
            description.textContent = cat.description

            const button = document.createElement("button")
            button.textContent = "Read more";
            button.classList.add("readMoreButton");

            catElement.appendChild(name);
            catElement.appendChild(age);
            catElement.appendChild(city);
            catElement.appendChild(description);
            catElement.appendChild(button);

            container.appendChild(catElement);
        })


    } catch (error) {
        console.error("error", error)
    }
}