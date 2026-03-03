# Baekjoon_4153

import sys

while True:
  side = sorted(list(map(int, sys.stdin.readline().split())))
  # side[2] is hypotenuse
  
  if side[0] == 0 and side[1] == 0 and side[2] == 0:
    break
  
  if side[0]**2 + side[1]**2 == side[2]**2:
    print("right")
  else:
    print("wrong")
