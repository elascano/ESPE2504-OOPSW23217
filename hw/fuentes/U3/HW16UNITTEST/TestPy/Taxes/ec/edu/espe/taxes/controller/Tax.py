class Tax:
    def compute_tax(self, base_price: float, percentage: float, charged: bool) -> float:
        if not charged:
            return 0.0
        else:
            iva_value = base_price * percentage / 100
            return iva_value

    def compute_ice(self, base_price: float) -> float:
        # TODO: Implement ICE computation logic
        return 0.0
