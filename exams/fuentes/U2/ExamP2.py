
from abc import ABC, abstractmethod
from typing import List, Optional
class H():
    @abstractmethod
    def r(self):
        pass


class A:
    def methodA(self):
        self.a_objects: List['A'] = []


class B(A, H):
    def methodB(self):
        super().__init__()

    def r(self):
        print("B")

class C(A):
    def methodC(self):
        super().__init__()
        self.e_list: List['E'] = []

class D(A):
    def methodD(self):
        super().__init__()

        self.e_list: List['E'] = []

class E:
    def methodE(self):
        pass
