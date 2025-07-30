class UniversityBusiness:
    def __init__(self, university):
        self.university = university

    def income_per_student(self):
        """
        Calcula el ingreso promedio por estudiante
        """
        if self.university.numberOfStudent == 0:
            return 0
        return self.university.monthlyIncome / self.university.numberOfStudent