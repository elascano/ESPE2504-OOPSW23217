class Employee:
    def __init__(self, name="not assigned yet", title="not assigned yet"):
        self.name = name
        self.title = title

    def state_name(self):
        print(f"{self.title} {self.name}")
