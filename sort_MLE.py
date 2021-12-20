#Baekjoon_10989

import sys

N = 10000
arr = [0 for _ in range(N+1)]

for i in range(int(sys.stdin.readline())):
    arr[int(sys.stdin.readline())] += 1

for i in range(len(arr)):
    for j in range(arr[i]):
        print(i)
