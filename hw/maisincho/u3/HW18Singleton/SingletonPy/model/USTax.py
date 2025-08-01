class USTax:
    __instance = None  # Static private variable to hold the single instance

    def __init__(self, tax_percentage):
        if USTax.__instance is not None:
            raise Exception("This class is a singleton! Use get_instance() instead.")
        self.__tax_percentage = tax_percentage
        USTax.__instance = self

    @classmethod
    def get_instance(cls):
        if cls.__instance is None:
            cls.__instance = USTax(0.2)
        return cls.__instance

    @classmethod
    def set_instance(cls, new_instance):
        if new_instance is not None:
            cls.__instance = new_instance
        else:
            print("Cannot set null instance")

    def get_tax_percentage(self):
        return self.__tax_percentage

    def set_tax_percentage(self, tax_percentage):
        self.__tax_percentage = tax_percentage