def print_maze_ascii(maze):
    N = maze.N
    M = maze.M
    rooms = maze.get_rooms()

    for i in range(N):

        for j in range(M):
            room = rooms[i][j]
            if room.has_wall('N'):
                print("+---", end="")
            else:
                print("+   ", end="")
        print("+")

        for j in range(M):
            room = rooms[i][j]
            if room.has_wall('W'):
                print("|", end="")
            else:
                print(" ", end="")

            if room.get_door():
                door_type = room.get_door().get_type()
                if door_type == "Entrance":
                    print(" E ", end="")
                elif door_type == "Exit":
                    print(" X ", end="")
                else:
                    print("   ", end="")
            else:
                print("   ", end="")

        print("|" if rooms[i][-1].has_wall('E') else " ")

    for j in range(M):
        if rooms[-1][j].has_wall('S'):
            print("+---", end="")
        else:
            print("+   ", end="")
    print("+")
