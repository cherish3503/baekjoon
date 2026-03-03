#Baekoon_1966

import sys
from collections import deque

def printer_queue(arr, n):
    importance = list()
    for i,p in enumerate(arr):
        importance.append((i,p))
    queue = deque(importance)
    arr.sort(reverse = True)
    
    count = 0
    while queue:
        tmp = queue.popleft()
        if tmp[1] != arr[0]:
            queue.append(tmp)
        else:
            count += 1
            del arr[0]
            if tmp[0] == n:
                return count
               
for i in range(int(sys.stdin.readline())):
    a, n = map(int, sys.stdin.readline().split())
    arr = list(map(int, sys.stdin.readline().split()))
    print(printer_queue(arr, n))
    
