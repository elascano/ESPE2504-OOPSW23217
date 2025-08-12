const http = require('http');

const hostname = '127.0.0.1';
const port = 3017;

const server = http.createServer((req, res) => { //request (what I ask) & response (what server gives)
    res.statusCode = 200;
    res.setHeader('Content-Type', 'text/plain');
    res.end('<b>Hello</b>, <i>Bernardo Suarez XD!</i>\n');
});

server.listen(port, hostname, () => {
    console.log(`Server running at http://${hostname}:${port}/`);
});