const http = require('http');
const hostname = '127.0.0.1';
const port = 3010;

const server = http.createServer((req, res) => {
res.statusCode = 200;
res.setHeader('Content-Type', 'text/html');
res.end('<b>Hello</b>, <i>Carlos!</i>\n');
});

server.listen(port, hostname, () => {
    console.log('server running at http://${hostname}:${port}/');
});