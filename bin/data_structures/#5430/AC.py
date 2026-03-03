# Baekjoon_5430

# 배열을 매번 뒤집지 않고 뒤집어진 경우 뒤에서 pop

import sys
from collections import deque

for _ in range(int(sys.stdin.readline())):
  p = deque(sys.stdin.readline())
  n = int(input())
  inp = sys.stdin.readline()
  queue = deque()

  if n != 0:
    queue = deque(inp.strip()[1:-1].split(','))
    # strip -> 개행문자 제거
    # [1:-1] -> 첫번째 마지막번째 문자 제거
  
  reversed_ = False
  while p:
    func = p.popleft()
    if func == 'R':
      reversed_ = not reversed_
        
    elif func == 'D':
      if len(queue) == 0:
        queue = -1
        break
      # 직접 뒤집지 않고 뒤집어진 경우 뒤에서 pop
      if reversed_:
        queue.pop()
      else:
        queue.popleft()
        
  if queue == -1:
    print('error')
    
  else:
    if reversed_:
      queue.reverse()
    print('['+','.join(map(str,queue))+']')
