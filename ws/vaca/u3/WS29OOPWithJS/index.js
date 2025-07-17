const port = 3019; // Port number for the server
const express = require('express'); // Onjeto que llama a contrctor de express
const app = express(); // CONSTRUCTOR
const mongoose= require('mongoose'); // Importing mongoose for MongoDB interactions

mongoose.connect(
    'mongodb+srv://oop:oop@cluster0.9knxc.mongodb.net/oop?retryWrites=true&w=majority', 
    { useNewUrlParser: true});

const db = mongoose.connection; // Getting the connection object

db.on("error", (error) => crossOriginIsolated.error(error)); // Handling connection errors
db.once("open", () => console.log("System coneected to MongoDb Database")); // Log when connected to MongoDB

app.use(express.json());
//REQUIERE = IMPORTAR       
const customerRouter = require("./routes/customerRouter"); // Importing customer routes

app.use("/computerstore", customerRouter); // Using the customer routes under the '/customers' path

app.listen(port, () => ("My Computer Store Server is running on port -->" + port)); // Starting the server and logging the port number