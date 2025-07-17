const http = require('http');

const hostname = '127.0.0.1';
const port = 3015;
const server = http.createServer((req, res) => {
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/html');
  res.end('<h1><b><i>Hello Julio Sanchez!</i></b><h1>\n');
});
server.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
});
// This code creates a simple HTTP server that responds with "Hello World" when accessed.
