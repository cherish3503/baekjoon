# Baekjoon_14500

import sys
sys.setrecursionlimit(10**6)

dy = [0,-1,0,1]
dx = [1,0,-1,0]

def tetromino(y, x, matrix, visited, sum_, depth):
  global result
  if depth == 4:
    result = max(result, sum_)
    return 

  if result >= sum_ + (4-depth)*max_val:
    # 나머지 수가 모두 최대 값이어도 결과값보다 작을 경우
    return

  for i in range(len(dy)):
    ny, nx = y+dy[i], x+dx[i]
    if ny<0 or nx<0 or ny>=len(matrix) or nx>=len(matrix[0]):
      # 인덱스 에러 방지
      continue
    if visited[ny][nx] == True:
      continue

    sum_ += matrix[ny][nx]
    visited[ny][nx] = True 
    tetromino(ny, nx, matrix, visited, sum_, depth+1)
    sum_ -= matrix[ny][nx]
    visited[ny][nx] = False

    if depth == 2:
      # 'ㅏ'모양의 경우 dfs로 처리불가능, 합과 방문여부만 체크 후 제자리로 이동
      sum_ += matrix[ny][nx]
      visited[ny][nx] = True 
      tetromino(y, x, matrix, visited, sum_, depth+1)
      sum_ -= matrix[ny][nx]
      visited[ny][nx] = False
      

n,m = map(int, sys.stdin.readline().split())
visited = [[False]*m for _ in range(n)]
matrix = list()
max_val = 0
for i in range(n):
  matrix.append(list(map(int, sys.stdin.readline().split())))
  max_val = max(max_val, max(matrix[i])) # 주어진 값 중 가장 큰 수


result = 0
sum_ = 0
for row in range(len(matrix)):
  for col in range(len(matrix[0])):
    sum_ += matrix[row][col]
    visited[row][col] = True
    tetromino(row, col, matrix, visited, sum_, 1)
    sum_ -= matrix[row][col]
    visited[row][col] = False

print(result)
