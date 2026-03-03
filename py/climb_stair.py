#Baekjoon_2579

import sys

d = list()

def climb_stair(stair):
  if len(stair) == 1 or len(stair) == 2:
    return sum(stair)

  d[0] = [stair[0], stair[0]]
  d[1] = [stair[0] + stair[1], stair[1]]
  # d[k] = (i1,i2) 
  # i1: k-1 -> k로 올라온 최대값, 
  # i2: k-2 -> k로  올라온 최대값

  for i in range(2,len(stair)):
    d[i][0] = d[i-1][1] + stair[i]
    d[i][1] = max(d[i-2][0], d[i-2][1]) +stair[i]

  return max(d[-1])


n = int(sys.stdin.readline())
d = [[0,0] for _ in range(n)]
stair = list()
for _ in range(n):
  stair.append(int(sys.stdin.readline()))

print(climb_stair(stair))
