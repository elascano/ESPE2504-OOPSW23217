const express = require("express");
const customer = require("../models/customer");
const router = express.Router();
//Get akk Custumers
router.get("/customers",async(req,res)=>{
    try{
        const customers = await customer.find();
        res.json(customers);
    }catch(err){
        res.status(500).json({message: err.message});
    }
});

router.get(`/customer/:id`, async(req, res)=>{
    try{
        const customerObject = await customer.findOne({id: req.params.iid});
        if(customerObject==null){
            res.status(400).json(404);
        }else{
            res.json(customerObject);
        }
    }
    catch(error){
        res.status(500).json({message: err.message});
    }
});
module.exports = router;