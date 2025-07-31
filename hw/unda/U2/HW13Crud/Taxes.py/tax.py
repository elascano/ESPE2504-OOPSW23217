# tax.py

class Tax:
    def computeTax(self, base_price: float, percentage: float, charged: bool) -> float:
        if charged:
            return base_price * (percentage / 100)
        else:
            return 0.0

    def testComputeIce(self, base_price: float) -> float:
        return 0.0
