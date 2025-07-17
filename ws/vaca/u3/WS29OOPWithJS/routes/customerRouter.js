const express = require('express'); //FRAMEWORK
const customer = require('../models/customer'); // Importing the Customer model
const router = express.Router(); // Creating a new router instance

// GET all customers
router.get("/customers", async (req, res) => {
    try {
        const customers = await customer.find(); // Fetching all customers from the database
        res.json(customers);
    } catch (error) {
        res.status(500).json({ message: error.message }); // Handling errors     
    }
});

module.exports = router; // Exporting the router to be used in other files

router.get("/customers/:id", async (req, res) => {
    try {
        const customerObject = await customer.findOne({id: req.params.id}); // Fetching a customer by ID
        if (customerObject ==null) {
            res.status(404).json(404); // Handling case where customer is not found
        } else {
            res.json(customerObject); // Returning the found customer   
        }
    } catch (error) {
        res.status(500).json({ message: error.message }); // Handling errors
    }
});