#Baekjoon_2581

import math

def isPrime(n):
    if n < 2 or n == 4:
        return False
    for i in range(2,math.floor(math.sqrt(n))+1):
        if n % i == 0:
            return False
        
    return True

inp1 = int(input())
inp2 = int(input())
sum = 0
primeI = -1

for i in range(inp1, inp2 + 1):
    if isPrime(i):
        if primeI == -1:
            primeI = i
        sum += i
        
if primeI == -1:
    print(primeI)
else:
    print(sum)
    print(primeI)
