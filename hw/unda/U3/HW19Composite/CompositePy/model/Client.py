class Client:
    employee = None  # atributo de clase

    @staticmethod
    def do_client_tasks():
        if Client.employee:
            Client.employee.state_name()
        else:
            print("No employee assigned")
