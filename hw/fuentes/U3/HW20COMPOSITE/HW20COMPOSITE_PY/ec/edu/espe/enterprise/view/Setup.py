from ec.edu.espe.enterprise.model.Teller import Teller
from ec.edu.espe.enterprise.model.Clerk import Clerk
from ec.edu.espe.enterprise.model.Manager import Manager
from ec.edu.espe.enterprise.model.President import President
from ec.edu.espe.enterprise.model.Client import Client

class Setup:
    @staticmethod
    def main():
        lonny = Teller("Lonny")
        cal = Clerk("Cal")
        able = Manager("Able")
        able.add(lonny)
        able.add(cal)

        juanita = Teller("Juanita")
        tina = Teller("Tina")
        thelma = Teller("Thelma")
        becky = Manager("Becky")
        becky.add(juanita)
        becky.add(tina)
        becky.add(thelma)

        pete = President.get_president("Pete")
        pete.add(able)
        pete.add(becky)

        Client.employee = pete
        Client.do_client_tasks()