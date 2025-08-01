from model.Teller import Teller
from model.Clerk import Clerk
from model.Manager import Manager
from model.President import President
from model.Client import Client  

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

if __name__ == "__main__":
    main()
