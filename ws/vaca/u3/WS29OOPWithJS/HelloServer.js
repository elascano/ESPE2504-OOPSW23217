const http= require('node:http'); //let or var - deprecated

const hostname = '127.0.0.1'; //localhost for every computer
const port = 3019; //port number 443 is reserved for HTTP

const server = http.createServer((req, res) => {
    res.statusCode = 200; //status code 200 means OK
    res.setHeader('Content-Type', 'text/plain'); //type toplain or json
    res.end('Hello Kevin!\n'); //end the response with Hello World
});

server.listen(port, hostname, () =>  {
    console.log(`Server running at http://${hostname}:${port}/`)
});           