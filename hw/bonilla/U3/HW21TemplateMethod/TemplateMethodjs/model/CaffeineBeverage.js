class CaffeineBeverage {
    async prepareRecipe() {
        this.boilWater();
        await this.brew();
        this.pourInCup();
        if (await this.wantsCondiments()) {
            this.addCondiments();
        }
    }

    boilWater() {
        console.log("Boiling water");
    }

    // métodos abstractos - deben implementar las subclases
    brew() {
        throw new Error("brew() must be implemented");
    }

    pourInCup() {
        console.log("Pouring into cup");
    }

    addCondiments() {
        throw new Error("addCondiments() must be implemented");
    }

    wantsCondiments() {
        return true;
    }
}

module.exports = CaffeineBeverage;
