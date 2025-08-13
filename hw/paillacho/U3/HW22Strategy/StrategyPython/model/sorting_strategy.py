from abc import ABC, abstractmethod

# Author: Carlos Paillacho


class SortingStrategy(ABC):

    @abstractmethod
    def sort(self, data):
        pass
