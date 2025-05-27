#author:Tammy Caizapanta

from model import Cable

if __name__ == '__main__':
    Cable = cable(
       cable_id=1,
       brand="Atlas",
       lenght="two meters",
       type="HDMI",
    )

    print("Cable data -->",)

    print(f"Cable --> {cable.Cable_id} ; {cable.brand}")