# Taxes/view/main.py

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from view.main_view import display_results

if __name__ == "__main__":
    display_results()
