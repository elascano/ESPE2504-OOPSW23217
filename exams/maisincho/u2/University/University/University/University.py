class University:
    def __init__(self, ID=None, name=None, monthlyIncome=None):
        self._ID = ID
        self._name = name
        self._monthlyIncome = monthlyIncome

    # Getters
    def get_ID(self):
        return self._ID

    def get_name(self):
        return self._name

    def get_monthlyIncome(self):
        return self._monthlyIncome

    # Setters
    def set_ID(self, ID):
        self._ID = ID

    def set_name(self, name):
        self._name = name

    def set_monthlyIncome(self, monthlyIncome):
        self._monthlyIncome = monthlyIncome

    def to_dict(self):
        return {
            "ID": self._ID,
            "name": self._name,
            "monthlyIncome": self._monthlyIncome
        }

    def __str__(self):
        return f"University[ID={self._ID}, name={self._name}, monthlyIncome={self._monthlyIncome}]"
