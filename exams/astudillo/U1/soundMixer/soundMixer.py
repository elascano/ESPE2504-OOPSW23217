import csv

class Equalizer:
    def __init__(self, bass=0, mid=0, treble=0):
        self._bass = bass
        self._mid = mid
        self._treble = treble

    def get_bass(self):
        return self._bass

    def get_mid(self):
        return self._mid

    def get_treble(self):
        return self._treble

    def set_bass(self, bass):
        self._bass = bass

    def set_mid(self, mid):
        self._mid = mid

    def set_treble(self, treble):
        self._treble = treble

    def to_dict(self):
        return {"bass": self._bass, "mid": self._mid, "treble": self._treble}

    def from_dict(self, data):
        self._bass = int(data["bass"])
        self._mid = int(data["mid"])
        self._treble = int(data["treble"])


class SoundMixer:
    def __init__(self, volume=50, balance=0, equalizer=None):
        if equalizer is None:
            equalizer = Equalizer()
        self._volume = volume
        self._balance = balance
        self._equalizer = equalizer

    def get_volume(self):
        return self._volume

    def get_balance(self):
        return self._balance

    def get_equalizer(self):
        return self._equalizer

    def set_volume(self, volume):
        self._volume = volume

    def set_balance(self, balance):
        self._balance = balance

    def set_equalizer(self, equalizer):
        self._equalizer = equalizer

    def to_dict(self):
        return {
            "volume": self._volume,
            "balance": self._balance,
            **self._equalizer.to_dict()
        }

    def from_dict(self, data):
        self._volume = int(data["volume"])
        self._balance = int(data["balance"])
        self._equalizer.from_dict(data)


class CSVHandler:
    def save_to_csv(file_path, sound_mixer):
        with open(file_path, mode='w', newline='') as file:
            writer = csv.DictWriter(file, fieldnames=["volume", "balance", "bass", "mid", "treble"])
            writer.writeheader()
            writer.writerow(sound_mixer.to_dict())

    def load_from_csv(file_path):
        with open(file_path, mode='r') as file:
            reader = csv.DictReader(file)
            for row in reader:
                equalizer = Equalizer()
                equalizer.from_dict(row)
                mixer = SoundMixer()
                mixer.from_dict(row)
                return mixer


equalizer = Equalizer(bass=5, mid=3, treble=-2)
mixer = SoundMixer(volume=100, balance=-10, equalizer=equalizer)

csv_file = "mixer_settings.csv"
CSVHandler.save_to_csv(csv_file, mixer)

loaded_mixer = CSVHandler.load_from_csv(csv_file)
print(loaded_mixer.get_volume())  
print(loaded_mixer.get_balance())  
print(loaded_mixer.get_equalizer().to_dict()) 