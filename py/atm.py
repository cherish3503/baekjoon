#Baekjoon_11399

import sys

def atm(arr):
    d = [0 for i in range(len(arr))]
    for i,t in enumerate(arr):
        if i == 0:
            d[i] = t
        else:
            d[i] = t + d[i-1]
    return sum(d)
    
sys.stdin.readline()
print(atm(sorted(list(map(int, sys.stdin.readline().split())))))
