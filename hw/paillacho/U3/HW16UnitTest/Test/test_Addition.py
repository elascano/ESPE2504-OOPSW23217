import unittest
from Addition import add_decimals
from decimal import Decimal

# Author Carlos Paillacho


class TestAddition(unittest.TestCase):

    def test_basic_addition(self):
        self.assertEqual(add_decimals(0.1, 0.2), Decimal('0.3'))

    def test_string_input(self):
        self.assertEqual(add_decimals('1.23', '4.56'), Decimal('5.79'))

    def test_negative_numbers(self):
        self.assertEqual(add_decimals('-2.5', '1.2'), Decimal('-1.3'))

    def test_zero_addition(self):
        self.assertEqual(add_decimals(0, '0.0'), Decimal('0.0'))

    def test_large_precision(self):
        self.assertEqual(
            add_decimals('0.00000000000000001', '1'),
            Decimal('1.00000000000000001')
        )


if __name__ == '__main__':
    unittest.main()
