import unittest
from controller.Operation import Operation

class TestOperation(unittest.TestCase):
    def test_add(self):
        result = Operation.add(1.2, 2.4)
        self.assertAlmostEqual(result, 3.6)

if __name__ == '__main__':
    unittest.main()
