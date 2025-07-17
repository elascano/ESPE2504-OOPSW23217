
const port = 4000;
const express = require('express');
const app = express();
const mongoose = require('mongoose');
const { use } = require('react');

mongoose.connect(`mongodb+srv://username:password@cluster0.9knxc.mongodb.net/oop?retryWrites=true&w=majority`, {
  useNewUrlParser: true,});
const db = mongoose.connection;
db.on('error', (error) => console.error(error));
db.once('open', () => {
  console.log('Connected to Database');
});

//call the method json of the express module
app.use(express.json());

const customerRouter = require('./routes/custumerRoutes');
app.use('/computerstore', customerRouter);

app.listen(port, () => {
  console.log(`My computers store server is running on port  ...>` + port)
});