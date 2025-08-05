class USTax:
    _instance = None
    
    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(USTax, cls).__new__(cls)
            cls._instance._initialized = False
        return cls._instance
    
    def __init__(self):
        if not self._initialized:
            try:
                with open('config.txt', 'r') as file:
                    line = file.readline().strip()
                    self.tax_rate = float(line.split('=')[1])
            except:
                self.tax_rate = 0.15  # default value
            self._initialized = True
    
    @classmethod
    def get_instance(cls):
        if cls._instance is None:
            cls._instance = cls()
        return cls._instance
    
    def sales_total(self):
        return 1000 + (1000 * self.tax_rate)
