class player:
    def __init__(self, id, name, salary, finalSalary, numberOfPoints, bono):
        self.id = id
        self.name = name
        self.salary = salary
        self.finalSalary = finalSalary
        self.numberOfPoints = numberOfPoints
        self.bono = bono

        self.salary_adjustment = self.calculate_salary()

    def calculate_salary(self):
        bonoPrice = 1000
        if self.bono:
            bonoPrice == self.numberOfPoints*bonoPrice

        return bonoPrice

