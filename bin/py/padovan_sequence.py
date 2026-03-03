#Baekjoon_9461

import sys

d = [0]*101
def padovan_sequence(n):
  if 1 <= n and n <= 3:
    return 1
  elif n == 4 or n == 5:
    return 2
  elif d[n] != 0:
    return d[n]
  else:
    d[n] = padovan_sequence(n-1) + padovan_sequence(n-5)
    return d[n]

for _ in range(int(sys.stdin.readline())):
  print(padovan_sequence(int(sys.stdin.readline())))

