def sum(addend1,addend2):
    return addend1 + addend2

def subtract(minuend, subtrahend):
    return minuend - subtrahend

def multiply(multiplicand, multiplier):
    return multiplicand * multiplier

def divide(dividend, divisor):
    if divisor == 0:
        raise ValueError("Cannot divide by zero")
    return dividend / divisor