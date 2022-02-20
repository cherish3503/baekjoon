# Baekjoon_11279
# heap
# 최소힙에서 각 값의 -1을 곱해 최대힙 구현

import heapq
import sys

heap = []

for _ in range(int(input())):
  x = int(sys.stdin.readline())
  if x == 0:
    if len(heap) == 0:
      print(0)
    else:
      print(-1 * heapq.heappop(heap))
      
  else:
    heapq.heappush(heap, -1 * x)
  
