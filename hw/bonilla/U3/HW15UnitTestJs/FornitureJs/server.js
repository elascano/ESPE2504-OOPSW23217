const express = require('express');
const app = express();
const routes = require('./routes');
const path = require('path');

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// Servir frontend estático (index.html)
app.use(express.static(path.join(__dirname, 'public')));

// Rutas API
app.use('/api/forniture', routes);

// Puerto
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});
