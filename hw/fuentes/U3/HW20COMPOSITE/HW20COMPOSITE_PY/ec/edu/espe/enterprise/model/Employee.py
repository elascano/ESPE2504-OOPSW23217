class Employee:
    def __init__(self, name="not assigned yet", title="not assigned yet"):
        self.name = name
        self.title = title

    def stateName(self):
        print(f"{self.title} {self.name}")