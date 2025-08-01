import unittest
from controller.Operation import Operation
class OperationTest (unittest.TestCase):
    def testAdd(self):
        result = Operation.add(1.2,2.4)
        self.assertEqual(result,3.6)
        
if __name__ == '__main__':
    unittest.main()