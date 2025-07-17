const//Julio port 3000 3001 = 3004
port = 3000;

const express = require("express");
const app = express();
const mongoose = require("mongoose");

mongoose.connect("mongodb+srv://oop:oop@cluster0.9iknxc.mongodb.net/oop?retryWrites=true&w=majority", {
  useNewUrlParser: true,});

const db = mongoose.connection;
db.on("error", (error) => console.error(error));
db.once("open", () => console.log("System connected to the database"));

app.use(express.json());   

const custommerRouter = require("./models/customerRoutes");
app.use("/customers", custommerRouter);

app.listen(port, () => console.log("My Computers Store Server is running on port --> "+ port));