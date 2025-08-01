"""
USTax class implementing Singleton pattern
@author Astudillo
"""
import os
import configparser


class USTax:
    """
    USTax class implementing Singleton pattern
    """
    _instance = None
    
    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(USTax, cls).__new__(cls)
            cls._instance._initialized = False
        return cls._instance
    
    def __init__(self):
        if self._initialized:
            return
        
        self.tax_rate = 0.15  # default value
        
        # Load configuration from properties file
        try:
            # Get the path to the resources directory
            current_dir = os.path.dirname(os.path.abspath(__file__))
            project_root = os.path.join(current_dir, '..', '..', '..', '..', '..')
            config_path = os.path.join(project_root, 'resources', 'config.properties')
            
            if os.path.exists(config_path):
                config = configparser.ConfigParser()
                
                # Read the properties file
                with open(config_path, 'r') as file:
                    config_string = '[DEFAULT]\n' + file.read()
                    config.read_string(config_string)
                
                # Get tax rate from configuration
                self.tax_rate = float(config.get('DEFAULT', 'tax.rate', fallback='0.15'))
                
        except Exception:
            self.tax_rate = 0.15  # default value
        
        self._initialized = True
    
    @staticmethod
    def get_instance():
        if USTax._instance is None:
            USTax._instance = USTax()
        return USTax._instance
    
    def sales_total(self):
        return 1000 + (1000 * self.tax_rate)
