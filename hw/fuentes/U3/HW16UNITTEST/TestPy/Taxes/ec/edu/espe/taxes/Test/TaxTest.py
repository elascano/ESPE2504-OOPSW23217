import unittest
from controller.Tax import Tax

class TestTax(unittest.TestCase):
    def ComputesTaxTest(self):
        result = self.tax.compute_tax(200.0, 10.0, True)
        self.assertAlmostEqual(result, 20.0)