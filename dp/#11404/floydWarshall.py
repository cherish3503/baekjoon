# Baekjoon_11404
# dp
# Floyd-Warshall

import sys
INF = 10**9

def floydWarshall(matrix):
  # 모든 도시에서 모든도시로의 최단거리를 구함
  for via in range(1,len(matrix)):
    for start in range(1,len(matrix)):
      if start == via:
        continue
      for end in range(1,len(matrix[0])):
        if end == via or start == end:
          continue
        matrix[start][end] = min(matrix[start][end], matrix[start][via] + matrix[via][end]) 
        # D_ab = min(D_ab, D_ak + D_kb)
  return matrix

n = int(input()) # 도시의 개수
matrix = [[INF]*(n+1) for _ in range(n+1)]
for start in range(len(matrix)):
  for end in range(len(matrix[0])):
    if start == end or start == 0 or end == 0:
      matrix[start][end] = 0
      
for i in range(int(input())):
  start, end, cost = map(int, sys.stdin.readline().split()) 
  # 출발도시, 도착도시, 비용
  matrix[start][end] = min(matrix[start][end], cost) # 버스 비용 중 최솟값
  
matrix = floydWarshall(matrix)
for start in range(1,len(matrix)):
  for end in range(1,len(matrix)):
    if matrix[start][end] == INF:
      matrix[start][end] = 0 # 갈 수 없는 경우
    print(matrix[start][end], end = ' ')
  print()
  # print(' '.join(map(str, matrix[start])))
