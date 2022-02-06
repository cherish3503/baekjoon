# Baekjoon_7569
# bfs

import sys
from collections import deque
sys.setrecursionlimit(10**6)

dx = [1,0,-1,0,0,0]
dy = [0,-1,0,1,0,0]
dz = [0,0,0,0,1,-1]

def ripeTomato(tomato, queue, day):
  global result
  if checkTomato(tomato):
    result = day
    return
  if len(queue) == 0:
    # queue가 비어 있을경우 모두 익지 못하는 상황
    result = -1
    return
  
  queue_n = deque()

  while(queue):
    # 새로 익은 토마토를 queue_n에 담음
    z, y, x = queue.pop()
    for i in range(len(dx)):
      nz,ny,nx = z+dz[i], y+dy[i], x+dx[i]
      if nz<0 or nz >=len(tomato) or ny<0 or ny >= len(tomato[0]) or nx<0 or nx >= len(tomato[0][0]):
        continue
      if tomato[nz][ny][nx] == 0:
        tomato[nz][ny][nx] = 1
        queue_n.append((nz,ny,nx))
  
  ripeTomato(tomato, queue_n, day+1)
  

def checkTomato(tomato):
  # 덜익은 토마토가 있는지 체크
  for box in tomato:
    for row in box:
      for i in row:
        if i == 0:
          return False
  return True

def startTomato(tomato):
  # 처음에 익어있는 토마토의 위치를 반환
  start = deque()
  for h in range(len(tomato)):
    for row in range(len(tomato[h])):
      for col in range(len(tomato[h][row])):
        if tomato[h][row][col] == 1:
          start.append((h,row,col))
  return start

m,n,h = map(int, sys.stdin.readline().split())
tomato = list()
for _ in range(h):
  box = list()
  for _ in range(n):
    box.append(list(map(int, sys.stdin.readline().split())))
  tomato.append(box)

ripeTomato(tomato, startTomato(tomato), 0)
print(result)
