"""
Main entry point for the Abstract Factory Pattern demonstration in Python

@author Astudillo
"""
from ec.edu.espe.composite.abstractfactory.view.ClientApp import ClientApp
import sys
import os

# Add the project root to the Python path
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))


if __name__ == "__main__":
    ClientApp.main()
