import unittest
from controller.Tax import Tax 

class TestTax(unittest.TestCase):

    def setUp(self):
        self.tax = Tax()

    def test_compute_tax(self):
        base = 200.0
        percent = 10.0
        charged = True
        result = self.tax.compute_tax(base, percent, charged)
        print(f"[TEST] compute_tax({base}, {percent}, {charged}) = {result}")
        self.assertAlmostEqual(result, 20.0)

    def test_compute_tax_not_charged(self):
        base = 200.0
        percent = 10.0
        charged = False
        result = self.tax.compute_tax(base, percent, charged)
        print(f"[TEST] compute_tax({base}, {percent}, {charged}) = {result}")
        self.assertEqual(result, 0.0)

if __name__ == '__main__':
    unittest.main()
