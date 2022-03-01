# Baekjoon_2206
# bfs

import sys
from collections import deque

INF = 10**9
dy = [0,-1,0,1]
dx = [1,0,-1,0]

def breakWall_move(y,x):
  queue = deque([(y,x,0,1)]) 
  #(y,x, 0: 벽을 부수지 않음 / 1: 벽을 이미 부숨, dist)

  while queue:
    y, x, wall, dist = queue.popleft()
    if distance[y][x][wall] != INF:
      # 해당 좌표까지의 거리가 최단거리가 아닌 경우
      # 각 벽부숨 여부에 대하여 INF가 아니면 최단거리 bfs
      continue

    if y == len(map_)-1 and x == len(map_[0])-1:
      return dist

    distance[y][x][wall] = dist
    
    for i in range(len(dy)):
      ny,nx = y+dy[i], x+dx[i]
      if ny<0 or nx<0 or ny>=len(map_) or nx>= len(map_[0]):
        continue
      if map_[ny][nx] == 0: # 벽이 아닌 경우
        queue.append((ny,nx,wall,dist+1))
      if wall == 0 and map_[ny][nx] == 1: # 벽을 부수지 않았고, 벽인 경우
        queue.append((ny,nx,1,dist+1))

  return -1
  
  
n, m = map(int, sys.stdin.readline().split())
map_ = list()
distance = [[[INF]*2 for i in range(m)] for i in range(n)]
# [[INF]*2]*m]*n 으로 구현시 reference만 복사되므로 사용하면 안된다.

#[벽을 부수지 않고 최소거리, 벽을 부수고 최소거리]
for _ in range(n):
  inp = sys.stdin.readline().rstrip()
  row = list()
  for i in inp:
    row.append(int(i))
  map_.append(row)

print(breakWall_move(0,0))
