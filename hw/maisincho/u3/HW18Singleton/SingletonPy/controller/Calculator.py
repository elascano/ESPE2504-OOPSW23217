from model.USTax import USTax

class Calculator:
    def sales_total(self, subtotal):
        tax = subtotal * USTax.get_instance().get_tax_percentage()
        total = subtotal + tax
        return total