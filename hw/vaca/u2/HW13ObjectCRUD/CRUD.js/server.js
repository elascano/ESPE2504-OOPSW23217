const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');

const app = express();
const PORT = 3000;

app.use(bodyParser.json());

app.use(express.static(__dirname));

const uri = 'mongodb+srv://KevinV593:KevinV593@cluster0.7ufczsp.mongodb.net/OOP?retryWrites=true&w=majority&appName=Cluster0';

mongoose.connect(uri, {
  useNewUrlParser: true,
  useUnifiedTopology: true,
})
.then(() => console.log('Connected to MongoDB'))
.catch(err => console.error('MongoDB connection error:', err));



app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});