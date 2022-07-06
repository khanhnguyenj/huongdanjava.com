const http = require("http");
let lodash = require("lodash");

const httpServer = http.createServer((req, res) => {
    res.statusCode = 200;
    res.setHeader('Content-Type', 'text/plain');
    res.end(lodash.upperCase('Hello World'));
});

httpServer.listen(8080, () => console.log('Server running on port 8080'));