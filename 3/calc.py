from math import sqrt
def add(a, b):
    return a + b
def subtract(a, b):
    return a - b
def multiply(a, b):
    return a * b
def divide(a, b):
    return a / b
def power(a, b):
    return a ** b

def calculation():
    print("What would you like to do? (+-*/^root)")
    validAnswer = False
    operation = ""
    while not validAnswer:
        operation = input().lower()
        if operation == "+" or operation == "-" or operation == "*":
            validAnswer = True
        elif operation == "/" or operation == "^" or operation == "root":
            validAnswer = True
    a = int(input("number: "))
    b = 0
    if operation != "root":
        b = int(input("Other number: "))
    result = 0
    if operation == "+":
        result = add(a, b)
    elif operation == "-":
        result = subtract(a, b)
    elif operation == "*":
        result = multiply(a, b)
    elif operation == "/":
        result = divide(a, b)
    elif operation == "^":
        result = power(a, b)
    elif operation == "root":
        result = sqrt(a)
    
    if result != "root":
        print("The result of " + str(a) + " " + str(operation) + " " + str(b) + " is " + str(result))
    else:
        print("The square root of " + str(a) + " is " + str(result))

def toContinue():
    print("Calculate something else?")
    get = input().lower()
    if get[0] == 'y':
        return True
    if get[0] == 'n':
        return False

if __name__ == "__main__":
   calculating = True
   while calculating:
       calculation()
       calculating = toContinue()
   print("Goodbye")


