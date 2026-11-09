async function talkBack(){

    try {
        response = await fetch("http://localhost:8080/api/hello");

        messege = await response.text();

        document.getElementById("displayMessege").textContent = messege;
    }
    catch (error){
        console.error("error communication with backend",error);
    }

}