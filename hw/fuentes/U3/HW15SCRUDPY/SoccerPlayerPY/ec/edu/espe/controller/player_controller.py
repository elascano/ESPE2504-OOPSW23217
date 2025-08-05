from model.soccer_player import SoccerPlayer

class PlayerController:
    def __init__(self):
        self.players = {}

    def add_player(self, player):
        if player.player_id in self.players:
            raise ValueError("Player with this ID already exists.")
        self.players[player.player_id] = player

    def update_player(self, player):
        if player.player_id not in self.players:
            raise ValueError("Player not found.")
        self.players[player.player_id] = player

    def delete_player(self, player_id):
        if player_id in self.players:
            del self.players[player_id]
        else:
            raise ValueError("Player not found.")

    def get_all_players(self):
        return list(self.players.values())

    def get_player(self, player_id):
        return self.players.get(player_id)
