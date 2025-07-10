const express = require('express');
const { connectDB } = require('./db');
const routes = require('./routes');

const app = express();
const port = 3000;

app.use(express.json());
app.use('/api', routes);
app.use(express.static('public')); // Sirve archivos HTML/JS/CSS desde /public

connectDB().then(() => {
  app.listen(port, () => {
    console.log(`Servidor escuchando en http://localhost:${port}`);
  });
}).catch(error => {
  console.error("No se pudo conectar a MongoDB, el servidor no arrancará", error);
});
