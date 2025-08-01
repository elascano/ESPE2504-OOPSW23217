from model.Clerk import Clerk
from model.Client import Client
from model.Manager import Manager
from model.President import President
from model.Teller import Teller

def main():
    # Organización de Able
    lonny = Teller("Lonny")
    cal = Clerk("Cal")
    able = Manager("Able")
    able.add(lonny)
    able.add(cal)

    # Organización de Becky
    juanita = Teller("Juanita")
    tina = Teller("Tina")
    thelma = Teller("Thelma")
    becky = Manager("Becky")
    becky.add(juanita)
    becky.add(tina)
    becky.add(thelma)

    # Reportes directos del presidente
    pete = President.get_president("Pete")
    pete.add(able)
    pete.add(becky)

    # Cliente ejecuta tareas
    Client.employee = pete
    Client.do_client_tasks()

if __name__ == "__main__":
    main()
