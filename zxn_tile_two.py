#Baekjoon_11727

import sys

d = [0]*1001
sys.setrecursionlimit(1001)

def zxn_tile(n):
  if n == 1:
    return 1
  elif n == 2:
    return 3
  elif d[n] != 0:
    return d[n]
  else:
    d[n] = zxn_tile(n-1) + 2*zxn_tile(n-2)
    return d[n]
  
print(zxn_tile(int(input()))%10007)
