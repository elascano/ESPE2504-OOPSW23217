class Client:
    employee = None

    @staticmethod
    def doClientTasks():
        if Client.employee:
            Client.employee.stateName()
