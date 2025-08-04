class USTax {
    constructor() {
        if (USTax.instance) {
            return USTax.instance;
        }
        
        // Initialize with default tax percentage
        this.taxPercentage = 7.0;
        
        // Store the singleton instance
        USTax.instance = this;
        
        return this;
    }
    
    // Method to set tax percentage
    setTaxPercentage(percentage) {
        this.taxPercentage = percentage;
    }
    
    // Method to get current tax percentage
    getTaxPercentage() {
        return this.taxPercentage;
    }
    
    // Method to calculate sales total with tax
    salesTotal(amount) {
        return amount * (1 + (this.taxPercentage / 100));
    }
    
    // Static method to get instance (similar to Java version)
    static getInstance() {
        if (!USTax.instance) {
            USTax.instance = new USTax();
        }
        return USTax.instance;
    }
}