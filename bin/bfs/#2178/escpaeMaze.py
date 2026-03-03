# Baekjoon_2178
# bfs

import sys
from collections import deque

def escapeMaze(maze):
  queue = deque([(0,0)])
  dy, dx = [0,-1,0,1], [1,0,-1,0]

  while queue:
    y, x = queue.popleft()
    for i in range(len(dy)):
      ny, nx = y+dy[i], x+dx[i]
      if ny >= len(maze) or ny < 0 or nx >= len(maze[0]) or nx < 0:
        continue
      if maze[ny][nx] != 1:
        continue
      if maze[ny][nx] == 1:
        maze[ny][nx] = maze[y][x] + 1
        queue.append((ny, nx))

  return maze[-1][-1]

n,m = map(int, sys.stdin.readline().split())
maze = list()
for _ in range(n):
  tmp = list()
  for i in sys.stdin.readline():
    if i != '\n':
      tmp.append(int(i))
  maze.append(tmp)

print(escapeMaze(maze))
