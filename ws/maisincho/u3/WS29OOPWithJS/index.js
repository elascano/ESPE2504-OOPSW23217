const //Isaac port 3000 3001 - 3024
port = 3000
const express = require ("express");
const app = express();
const mongoose = require("mongoose");

mongoose.connect(`mongodb+srv://<user>:<password>@cluster0.9knxc.mongodb.net/oop?retryWrites=true&w=majority`,  {useNewUrlParser: true});

  const db = mongoose.connection;

  db.on("error", (error) => crossOriginIsolated.error(error));
  db.once("open", () => console.log("system connectd to MongoDb Database"));
  app.use(express.json());

  const customerRouter = require ("./routes/customerRoutes");
  app.use("/computerstore", customerRouter);

  app.listen(port, () => console.log("My Computers Store Server is running on port --> " + port));