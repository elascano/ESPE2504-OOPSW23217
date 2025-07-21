//import { createServer } from 'nodemon:http';
const http = require('node:http');
const hostname = '127.0.0.1';
const port = 3008;
const server = http.createServer((req, res) => {
    res.statusCode = 200;
    res.setHeader('Content-Type', 'text/plain');
    res.end('<b> SKR <b>, <i> Isaac Maisincho <i> Hello World\n');
});
server.listen(port, hostname, () => {
    console.log(`Server running at http://${hostname}:${port}/`);
});