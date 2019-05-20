from math import sqrt
def isPrime(x):
    for i in range(2, int(sqrt(x) + 1)):
        if x % i == 0:
            return False
    return True;
sum = 0
for i in range(2, 3000):
    if isPrime(i):
        sum += i
print(sum)
