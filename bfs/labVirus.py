# Baekjoon_14502
# bfs


import sys
import itertools
import copy
from collections import deque

dy = [0,-1,0,1]
dx = [1,0,-1,0] 

def virusWall(wall, map_, queue):
  # 특정 벽 세우기에 대하여 바이러스 전염 후 안전영역 리턴
  for w in wall: # 벽 세우기
    y,x = w
    map_[y][x] = 1

  blk_cnt = checkSafe(map_) 
  # 탈출조건 maz_val보다 작아진 경우 탈출

  while queue: # 바이러스 전염
    y,x = queue.popleft()
    if map_[y][x] != 0:
      continue # 시작지점 바이러스는 0으로 미리 변경
    map_[y][x] = 2
    
    blk_cnt -= 1
    if blk_cnt <= max_val:
      return 0 # max_val보다 작아진 경우
    
    for i in range(len(dy)):
      ny,nx = y+dy[i],x+dx[i]
      if ny<0 or nx<0 or ny>=len(map_) or nx>=len(map_[0]):
        continue
      if map_[ny][nx] != 0:
        continue

      queue.append((ny,nx))
  return checkSafe(map_)
  

def startVirus(map_): # 처음 바이러스 좌표 리턴
  queue = deque()
  for row in range(len(map_)):
    for col in range(len(map_[0])):
      if map_[row][col] == 2:
        map_[row][col] = 0
        # 시작지점 바이러스는 0으로 미리 변경
        queue.append((row, col))

  return queue

def checkSafe(map_): # 안전영역 카운트
  cnt = 0
  for row in range(len(map_)):
    for col in range(len(map_[0])):
      if map_[row][col] == 0:
        cnt += 1
  return cnt

n,m = map(int, sys.stdin.readline().split())
map_init = list()
for _ in range(n):
  map_init.append(list(map(int, sys.stdin.readline().split())))

blank_ = list()
for row in range(n):
  for col in range(m):
    if map_init[row][col] == 0:
      blank_.append((row,col))
blank_comb = list(itertools.combinations(blank_,3))

max_val = 0 # 최댓값 구하기
map_ = list()
for wall in blank_comb:
  map_ = copy.deepcopy(map_init)
  max_val = max(virusWall(wall, map_, startVirus(map_)), max_val)

print(max_val)
