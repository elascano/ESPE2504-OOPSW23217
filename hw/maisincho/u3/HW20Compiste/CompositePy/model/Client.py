class Client:
    employee = None  # atribute static
    @staticmethod
    def do_client_tasks():
        if Client.employee is not None:
            Client.employee.state_name()
