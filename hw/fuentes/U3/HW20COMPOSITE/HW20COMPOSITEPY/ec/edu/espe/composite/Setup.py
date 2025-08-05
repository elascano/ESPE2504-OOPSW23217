from model.Teller import Teller
from model.Clerk import Clerk
from model.Manager import Manager
from model.President import President
from view.Client import Client

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

    pete = President("Pete")
    pete.add(able)
    pete.add(becky)

    Client.employee = pete
    Client.doClientTasks()

if __name__ == "__main__":
    main()
