# test_tax.py

import unittest
from tax import Tax

class TestTax(unittest.TestCase):

    def test_compute_tax(self):
        print("Running test_compute_tax...")
        tax = Tax()
        result = tax.computeTax(100.0, 15.0, True)
        expected = 15.0
        self.assertAlmostEqual(result, expected, places=6)

    def test_compute_zero_tax(self):
        print("Running test_compute_zero_tax...")
        tax = Tax()
        result = tax.computeTax(100.0, 15.0, False)
        expected = 0.0
        self.assertAlmostEqual(result, expected, places=6)

    def test_compute_ice(self):
        print("Running test_compute_ice...")
        tax = Tax()
        result = tax.testComputeIce(0.0)
        expected = 0.0
        self.assertAlmostEqual(result, expected, places=6)

if __name__ == '__main__':
    unittest.main()
