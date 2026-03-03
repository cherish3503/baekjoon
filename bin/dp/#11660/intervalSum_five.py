# Baekjoon_11660
# dp

import sys

n,m = map(int, sys.stdin.readline().split())
table = list()
for _ in range(n):
  table.append(list(map(int, sys.stdin.readline().split())))
for i in range(len(table)):
  sum_row = 0
  for j in range(len(table[0])):
    table[i][j] += sum_row
    sum_row = table[i][j]
    if i != 0:
      table[i][j] += table[i-1][j]
# 각 행의 합을 구하고 이전 행의 같은 열 값을 더한다
# 각 값은 (1,1) 부터의 합
for _ in range(m):
  x1,y1,x2,y2 = map(int, sys.stdin.readline().split())
  x1,y1,x2,y2 = x1-1,y1-1,x2-1,y2-1

  result = table[x2][y2] - table[x1-1][y2] - table[x2][y1-1] + table[x1-1][y1-1]
  if x1 == 0 or y1 == 0:
    if x1 == 0:
     result += table[x1-1][y2]
    if y1 == 0:
      result += table[x2][y1-1]
    result -= table[x1-1][y1-1]
    # x1, y1 값이 1인경우 error 방지

  print(result)
