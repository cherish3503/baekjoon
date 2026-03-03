# Baekjooon_1927

import sys
import heapq

heap = []

for _ in range(int(input())):
  inp = int(sys.stdin.readline())
  if inp == 0:
    if len(heap) == 0:
      print(0)
    else:
      print(heapq.heappop(heap))
  else:
    heapq.heappush(heap, inp)
