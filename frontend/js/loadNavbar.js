async function loadNavbar(){
    try{
        const response = await fetch("navBar.html")

        const navbar = await response.text()

        document.getElementById("navBar").innerHTML = navbar;
    } catch (error){
        console.log("error",error);
    }
}