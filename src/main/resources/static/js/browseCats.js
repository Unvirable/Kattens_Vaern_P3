let cats;

async function getCats() {
    try {
        const response = await fetch('/api/getCats')

        if (!response.ok) {
            throw new Error("Failed to fetch cats")
        }

        cats = await response.json()
        renderCats(cats);
    } catch (error) {
        console.error("error", error)
    }
}

function renderCats(cats){
        const container = document.getElementById("catContainer");
        container.innerHTML = "";

        cats.forEach(cat =>{
            const catElement = document.createElement("div");
            catElement.classList.add("cat");

            const img = document.createElement("img")
            img.src = `/api/getCatImage?id=${cat.id}`;
            img.alt = cat.name;
            img.loading = "lazy";
            img.classList.add("catImage");
            img.onerror = () => {
                img.onerror = null;
                img.src = "/images/placeholder.jpg"
            }

            const name = document.createElement("h2");
            name.textContent = "Navn: " + cat.name;

            const age = document.createElement("h2")
            age.textContent = "Fødselsdag: " + cat.birthday;

            const city = document.createElement("h2");
            city.textContent = "By: " + cat.locatedInLabel;

            const catType = document.createElement("h2");
            catType.textContent = "Type: " + cat.catTypeLabel

            const description = document.createElement("p")
            description.textContent = cat.description;
            description.classList.add("SmallDescription")

            const button = document.createElement("button")
            button.textContent = "Read more";
            button.classList.add("readMoreButton");
            button.addEventListener("click", () => {
                window.location.href = `individualCatInfo.html?id=${cat.id}`
            });

            catElement.appendChild(img);
            catElement.appendChild(name);
            catElement.appendChild(age);
            catElement.appendChild(city);
            catElement.appendChild(catType);
            catElement.appendChild(description);
            catElement.appendChild(button);

            container.appendChild(catElement);
        })
}
document.getElementById("filter").addEventListener("change", (event) => {
    const city = event.target.value;
    const filtered = city ? cats.filter(cat => cat.locatedIn === city) : cats;
    renderCats(filtered)
})

async function getCatDetails(){
    const params = new URLSearchParams(window.location.search);
    const id = params.get("id");

    try{
        const response = await fetch(`/api/findCatById?id=${encodeURIComponent(id)}`)
        if (!response.ok){
            throw new Error("Cat doesnt exist in database")
        }
        const cat = await response.json()
        const catBox = document.getElementById("catDetails");

        const img = document.createElement("img")
        img.src = `/api/getCatImage?id=${cat.id}`;
        img.alt = cat.name;
        img.classList.add("catImage");
        img.onerror = () => {
            img.onerror = null;
            img.src = "/images/placeholder.jpg"
        }

        const name = document.createElement("h2")
        name.textContent = cat.name;

        const foedselsdag = document.createElement("h2")
        foedselsdag.textContent = "Fødselsdag: " + cat.birthday;

        const catType = document.createElement("h2")
        catType.textContent = "Type: " + cat.catTypeLabel;

        const city = document.createElement("h2")
        city.textContent = "By: " + cat.locatedInLabel;

        const description = document.createElement("p")
        description.textContent = cat.description;

        catBox.appendChild(img)
        catBox.appendChild(name)
        catBox.appendChild(foedselsdag)
        catBox.appendChild(catType)
        catBox.appendChild(city)
        catBox.appendChild(description)
    } catch(error){
        console.error("Error", error)
    }
}