


const inputField = document.getElementById("chat-input");
const outputArea = document.getElementById("chat-area");

console.log(inputField)

const usercount = document.getElementById("user-count")
const socketRoute = document.getElementById("ws-route").value;
const socket = new WebSocket(socketRoute.replace("http", "ws"));


inputField.onkeydown = (event) => {
    if(event.key === 'Enter'){
        console.log(inputField.value);
        socket.send(inputField.value);
        inputField.value = '';
    }
}
socket.onopen = (event) => socket.send("New user connected");

socket.onmessage = (event) => {
    outputArea.value += '\n' + event.data;
    outputArea.scrollTop = outputArea.scrollHeight;
}


setInterval(function(){
    $.get("/name", function(data, status){
        usercount.innerText = "Number of users: "+ data;
        console.log(data)
    });
    }, 1000);
