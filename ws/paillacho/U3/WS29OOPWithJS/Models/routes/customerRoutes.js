const express = require("express");
const  customer = require("../models/customer");
const router = express.Router();
//Get all Customers
router.get("/customers", async (req,res) => {
    try{
        const customers = await customer.find();
        res.json(customers);
    } catch (err) {
        res.status(500).jason({ message: err.message});
    }
});

module.exports = router;