#Baekjoon_10866

from collections import deque
import sys

deq = deque()

for i in range(int(sys.stdin.readline())):
    inp = sys.stdin.readline().split()
    
    if inp[0] == 'push_front':
        deq.appendleft(inp[1])
    if inp[0] == 'push_back':
        deq.append(inp[1])
    if inp[0] == 'pop_front':
        if len(deq) == 0:
            print(-1)
        else:
            print(deq.popleft())
    if inp[0] == 'pop_back':
        if len(deq) == 0:
            print(-1)
        else:
            print(deq.pop())
        
    if inp[0] == 'size':    
        print(len(deq))

    if inp[0] == 'empty':
        if len(deq) == 0:
            print(1)
        else:
            print(0)
            
    if inp[0] == 'front':
        if len(deq) == 0:
            print(-1)
        else:
            print(deq[0])
            
    if inp[0] == 'back':
        if len(deq) == 0:
            print(-1)
        else:
            print(deq[len(deq)-1])
                        
