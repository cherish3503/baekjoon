# Baekjoon_2667
# bfs

import sys
from collections import deque

dx = [1,0,-1,0]
dy = [0,-1,0,1]

def num_estate(queue):
  # 한 단지의 집의 수를 카운트
  count = 0
  while(queue):
    y, x = queue.popleft()
    if estate[y][x] != 1:
      continue
    
    estate[y][x] = 2 # 이미 센 집은 2로 수정
    count += 1
    for i in range(len(dx)):
      ny, nx = y+dy[i], x+dx[i]
      if not (ny<0 or nx<0 or ny>= len(estate) or nx>=len(estate)):
        queue.append((ny,nx))
      
  return count
      

n = int(input())
estate = list()
for _ in range(n):
  row = list()
  for i in sys.stdin.readline():
    if i != '\n':
      row.append(int(i))
  estate.append(row)

queue = deque()
result = list()
for row in range(len(estate)):
  for col in range(len(estate[0])):
    if estate[row][col] == 1:
      queue.append((row,col))
      result.append(num_estate(queue))

result.sort()
print(len(result))
for i in result:
  print(i)

