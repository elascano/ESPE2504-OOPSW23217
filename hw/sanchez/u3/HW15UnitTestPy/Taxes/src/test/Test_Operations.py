from src.controller.Operations import sum, subtract, multiply, divide

def test_sum():
    assert sum(2, 3) == 5
    assert sum(-1, 1) == 0
    assert sum(0, 0) == 0

def test_subtract():
    assert subtract(5, 3) == 2
    assert subtract(0, 0) == 0
    assert subtract(3, 5) == -2

def test_multiply():
    assert multiply(2, 3) == 6
    assert multiply(-1, 1) == -1
    assert multiply(0, 5) == 0

def test_divide():
    assert divide(6, 3) == 2
    assert divide(-6, 3) == -2
    assert divide(0, 1) == 0
    try:
        divide(1, 0)
    except ValueError as e:
        assert str(e) == "Cannot divide by zero"