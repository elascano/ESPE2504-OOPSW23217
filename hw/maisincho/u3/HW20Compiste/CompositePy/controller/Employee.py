class Employee:
    def __init__(self, name, title):
        self.name = name
        self.title = title
        self.subordinates = [] 

    def add(self, employee):
        self.subordinates.append(employee)

    def remove(self, employee):
        if employee in self.subordinates:
            self.subordinates.remove(employee)

    def state_name(self):
        print(f"{self.title} {self.name}")
        for e in self.subordinates:
            e.state_name()
