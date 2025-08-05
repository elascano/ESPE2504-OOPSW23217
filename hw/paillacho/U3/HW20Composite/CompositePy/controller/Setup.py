"""
Entry point for composite structure creation.
@author Carlos Paillacho
"""
from model.Teller import Teller
from model.Clerk import Clerk
from model.Manager import Manager
from model.President import President
from controller.Client import Client


def main():
    # Build Able's organization
    lonny = Teller("Lonny")
    cal = Clerk("Cal")
    able = Manager("Able")
    able.add(lonny)
    able.add(cal)

    # Build Becky's organization
    juanita = Teller("Juanita")
    tina = Teller("Tina")
    thelma = Teller("Thelma")
    becky = Manager("Becky")
    becky.add(juanita)
    becky.add(tina)
    becky.add(thelma)

    # Create the president's direct reports (singleton)
    pete = President.get_president("Pete")
    pete.add(able)
    pete.add(becky)

    # Initiate client
    Client.employee = pete
    Client.do_client_tasks()


if __name__ == "__main__":
    main()
