#Baekjoon_1003

import sys

d = [[0,0] for i in range(41)]

def countFib(n):
    if n == 0:
        return [1,0]
    elif n == 1:
        return [0,1]
    elif d[n] != [0,0]:
        return d[n]
    c_Fib1 = countFib(n-1)
    c_Fib2 = countFib(n-2)
    d[n][0] = c_Fib1[0] + c_Fib2[0]
    d[n][1] = c_Fib1[1] + c_Fib2[1]
    return d[n]
   
for i in range(int(sys.stdin.readline())):
    arr = countFib(int(sys.stdin.readline()))
    print(arr[0], arr[1])
