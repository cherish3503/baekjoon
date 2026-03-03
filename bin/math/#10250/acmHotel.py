# Baekjoon_10250

import sys

for i in range(int(input())):
  h,w,n = map(int, sys.stdin.readline().split())
  y = n%h
  x = n//h + 1

  if y == 0:
    # 꼭대기 층
    y = h
    x -= 1
  
  if x < 10:
    x = '0' + str(x)
  else:
    x = str(x)

  y = str(y)
  
  print(int(y + x))
