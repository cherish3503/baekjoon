# Baekjooon_4963

import sys
sys.setrecursionlimit(10**6)

def numberOfIsland(field, y, x):
  # dfs
  if y < 0 or x < 0 or y >= len(field) or x >= len(field[0]):
    return False
    # Index error 방지
  
  if field[y][x] == 0:
    return False

  field[y][x] = 0
  dy = [1,0,-1,-1,-1,0,1,1]
  dx = [1,1,1,0,-1,-1,-1,0]

  for i in range(len(dy)):
    numberOfIsland(field, y+dy[i], x+dx[i])
  

while(True):
  w, h = map(int, sys.stdin.readline().split())

  if w == 0 and h == 0:
    break # 탈출조건

  field = list()
  for _ in range(h):
    field.append(list(map(int, sys.stdin.readline().split())))
  
  count = 0
  for y in range(len(field)):
    for x in range(len(field[0])):
      if field[y][x] == 1:
        numberOfIsland(field, y, x)
        count += 1
  print(count)

  
