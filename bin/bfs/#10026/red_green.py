# Baekjoon_10026
# bfs

import sys
from collections import deque
colors = ['R','G','B']
color_rg_b = [0,0,1]
dy = [0,-1,0,1]
dx = [1,0,-1,0]

def rgb(queue, color):
  # 적록색약이 없는 사람
  # RGB -> 001
  while(queue):
    y, x = queue.popleft()
    if grid[y][x] != color:
      continue
    grid[y][x] = color_rg_b[colors.index(grid[y][x])] # R,G,B = 0,0,1
    for i in range(len(dy)):
      ny,nx = y+dy[i], x+dx[i]
      if(ny<0 or nx<0 or ny>=len(grid) or nx>=len(grid[0])):
        continue
      queue.append((ny, nx))

def rg_b(queue, color):
  # 적록색약
  # 001 -> 333
  while(queue):
    y, x = queue.popleft()
    if grid[y][x] != color:
      continue
    grid[y][x] = 3
    for i in range(len(dy)):
      ny,nx = y+dy[i], x+dx[i]
      if(ny<0 or nx<0 or ny>=len(grid) or nx>=len(grid[0])):
        continue
      queue.append((ny, nx))


n = int(input())
grid = list()
for i in range(n):
  row = list()
  for i in sys.stdin.readline():
    if i != '\n':
      row.append(i)
  grid.append(row)

# 적록색약이 없는 경우
queue = deque()
count_rgb = 0
for row in range(len(grid)):
  for col in range(len(grid[0])):
    if grid[row][col] in colors:
      queue.append((row, col))
      rgb(queue, grid[row][col])
      count_rgb += 1

# 적록색약이 있는 졍우
count_rg_b = 0
for row in range(len(grid)):
  for col in range(len(grid[0])):
    if grid[row][col] == 0 or grid[row][col] == 1:
      queue.append((row, col))
      rg_b(queue, grid[row][col])
      count_rg_b += 1

print(count_rgb, count_rg_b)
