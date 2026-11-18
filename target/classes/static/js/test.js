async function talkBack(){

    try {
        response = await fetch("/api/hello");

        messege = await response.text();

        document.getElementById("displayMessege").textContent = messege;
    }
    catch (error){
        console.error("error communication with backend",error);
    }

}