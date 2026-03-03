#Baekjoon_2164

import sys
from collections import deque

def lastCard(n):
    deq = deque(range(1,n+1))

    while len(deq) > 1:
        deq.popleft()
        deq.append(deq.popleft())
    
    return deq.pop()

print(lastCard(int(sys.stdin.readline())))
