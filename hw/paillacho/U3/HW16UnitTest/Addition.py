from decimal import Decimal, getcontext

# Author Carlos Paillacho

getcontext().prec = 28


def add_decimals(a, b):

    return Decimal(str(a)) + Decimal(str(b))
