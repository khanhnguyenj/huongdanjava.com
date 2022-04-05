const { Server } = require("socket.io");
const httpServer = require("http").createServer();

const io = new Server(httpServer);

io.on("connection", (socket) => {
  console.log("Connected to client!");

  socket.emit("welcome", "Hello");

  socket.on("welcome", (data) => {
    console.log(data);
  });
});

httpServer.listen(8080, () => console.log("Server running on port 8080"));
