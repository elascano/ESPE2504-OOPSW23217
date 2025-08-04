class CaffeineBeverage:
    def prepareRecipe(self):
        self.boilWater()
        self.brew()
        self.pourInCup()
        if self.wantsCondiments():
            self.addCondiments()

    def boilWater(self):
        print("Boiling water")

    def pourInCup(self):
        print("Pouring into cup")

    def brew(self):
        raise NotImplementedError("Subclasses must implement brew()")

    def addCondiments(self):
        raise NotImplementedError("Subclasses must implement addCondiments()")

    def wantsCondiments(self):
        return True
