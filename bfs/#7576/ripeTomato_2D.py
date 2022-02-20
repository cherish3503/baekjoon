# Baekjoon_7576
# bfs

import sys
from collections import deque
sys.setrecursionlimit(10**6)

dx = [1,0,-1,0]
dy = [0,-1,0,1]

def ripeTomato(tomato, queue):
  day = 0
  while(queue):
    y, x, day = queue.popleft()
    for i in range(len(dx)):
      ny,nx = y+dy[i], x+dx[i]
      if ny<0 or ny >= len(tomato) or nx<0 or nx >= len(tomato[0]):
        continue
      if tomato[ny][nx] == 0:
        tomato[ny][nx] = 1
        queue.append((ny,nx,day+1))

  if checkTomato(tomato):
    return day
  else:
    return -1

def checkTomato(tomato):
  # 덜익은 토마토가 있는지 체크
  for row in tomato:
    for i in row:
      if i == 0:
        return False
  return True


def startTomato(tomato):
  # 처음에 익어있는 토마토의 위치를 반환
  start = deque()
  for row in range(len(tomato)):
    for col in range(len(tomato[row])):
      if tomato[row][col] == 1:
        start.append((row,col,0)) # (row,col,day)
  return start

m,n = map(int, sys.stdin.readline().split())
tomato = list()
for _ in range(n):
  tomato.append(list(map(int, sys.stdin.readline().split())))

print(ripeTomato(tomato, startTomato(tomato)))
