const mongoose = require('mongoose'); // Importing mongoose for MongoDB interactions

const customerSchema = new mongoose.Schema(
    {
        id: {type: Number},
        name: {type: String},
        age: {type: Number},
        moneySpent: {type: Number}
    },
    {  collection: "Customers" }
);

module.exports = mongoose.model("Customer", customerSchema); // Exporting the Customer model            