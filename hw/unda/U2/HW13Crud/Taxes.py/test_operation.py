# test_operation.py

import unittest
from operation import Operation

class TestOperation(unittest.TestCase):

    def test_add(self):
        print("Running test_add...")
        result = Operation.add(1.2, 2.4)
        expected = 3.6
        self.assertAlmostEqual(result, expected, places=6)

if __name__ == '__main__':
    unittest.main()
