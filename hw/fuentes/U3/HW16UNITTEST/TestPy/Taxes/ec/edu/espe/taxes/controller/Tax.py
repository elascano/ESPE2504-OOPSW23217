class Tax:
    def computeTax(basePrice: float, percentage: float, charged: bool):
        if not charged:
            return 0.0
        else:
            ivaValue = basePrice*percentage/100
            return ivaValue
        
    def computeIce(basePrice: float):
        #CODE THE COMPUTATION OD ICE
        return 0.0
        