from ec.edu.espe.enterprise.model.Employee import Employee

class Clerk(Employee):
    def __init__(self, name="not assigned yet"):
        super().__init__(name, "Clerk")