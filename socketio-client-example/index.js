const { io } = require("socket.io-client");

const socket = io("http://localhost:8080", { autoConnect: false });

socket.onAny((event, ...args) => {
  console.log(event, args);
});

socket.emit("welcome", "Hello from client");

socket.connect();