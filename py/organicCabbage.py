#Baekjoon_1012

import sys
sys.setrecursionlimit(10**6)

def organicCabbage(field,x,y):
  # dfs
  if x < 0 or y < 0 or x >= m or y >= n:
    return False

  if field[x][y] == 0:
    return False

  field[x][y] = 0

  nx = [1,0,-1,0]
  ny = [0,-1,0,1]

  for i in range(len(nx)):
    organicCabbage(field,x+nx[i],y+ny[i])
  
  return True


t = int(sys.stdin.readline())
for _ in range(t):
  m,n,k = map(int, sys.stdin.readline().split())
  # m: 가로, n: 세로, k: 배추의 수
  field = [[0]*n for _ in range(m)]
  for _ in range(k):
    x, y = map(int, sys.stdin.readline().split())
    field[x][y] = 1
  
  result = 0
  for i in range(m):
    for j in range(n):
      if organicCabbage(field,i,j):
        result += 1
  print(result)

