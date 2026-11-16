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
            name.textContent = "Navn: " + cat.name;

            const age = document.createElement("h2")
            age.textContent = "Alder: " + cat.age;

            const city = document.createElement("h2");
            city.textContent = "By: " + cat.city;

            const description = document.createElement("h2");
            description.textContent = cat.description

            const button = document.createElement("button")
            button.textContent = "Read more";
            button.classList.add("readMoreButton");
            button.addEventListener("click", () => {
                window.location.href = `individualCatInfo.html?id=${cat.id}`
            });

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

async function getCatDetails(){
    const params = new URLSearchParams(window.location.search);
    const id = params.get("id");

    try{
        const response = await fetch(`http://localhost:8080/api/findCatById?id=${encodeURIComponent(id)}`)
        if (!response.ok){
            throw new Error("Cat doesnt exist in database")
        }
        const cat = await response.json()
        const catBox = document.getElementById("catDetails");

        const name = document.createElement("h2")
        name.textContent = cat.name;

        const age = document.createElement("h2")
        age.textContent = cat.age;

        const city = document.createElement("h2")
        city.textContent = cat.city;

        const description = document.createElement("h2")
        description.textContent = cat.description;

        catBox.appendChild(name)
        catBox.appendChild(age)
        catBox.appendChild(city)
        catBox.appendChild(description)
    } catch(error){
        console.error("Error", error)
    }
}