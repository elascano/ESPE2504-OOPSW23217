"""
@author Carlos Paillacho
"""
from model.Employee import Employee


class Client:
    """
    Relates to a specific Employee instance.
    """
    employee: Employee = None

    @staticmethod
    def do_client_tasks():
        if Client.employee is not None:
            Client.employee.state_name()
