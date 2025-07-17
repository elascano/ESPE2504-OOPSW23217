// server.js
import express from 'express';
import { connectDB } from './db.js';
import routes from './routes.js';

const app = express();
const port = 3000;

app.use(express.json());
app.use('/api', routes);
app.use(express.static('public'));

connectDB().then(() => {
  app.listen(port, () => {
    console.log(`Servidor escuchando en http://localhost:${port}`);
  });
}).catch(error => {
  console.error("No se pudo conectar a MongoDB, el servidor no arrancará", error);
});
