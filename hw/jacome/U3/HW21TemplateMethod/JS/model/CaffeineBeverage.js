class CaffeineBeverage {
    prepareRecipe() {
        this.boilWater();
        this.brew();
        this.pourInCup();
        // Eliminamos la condición de wantsCondiments de aquí
    }
    
    boilWater() {
        console.log("Boiling water");
    }
    
    brew() {
        throw new Error("Abstract method brew() must be implemented");
    }
    
    pourInCup() {
        console.log("Pouring into cup");
    }
    
    addCondiments() {
        throw new Error("Abstract method addCondiments() must be implemented");
    }
}

module.exports = CaffeineBeverage;