#Baekjoon_1260

import sys
from collections import deque

dfs_arr = list()
bfs_arr = list()

def dfs(graph, v, visited):
  visited[v] = True
  dfs_arr.append(v)

  for i in graph[v]:
    if not visited[i]:
      dfs(graph, i, visited)

def bfs(graph, start, visited):
  visited[start] = True
  queue = deque([start])

  while queue:
    v = queue.popleft()
    bfs_arr.append(v)

    for i in graph[v]:
      if not visited[i]:
        queue.append(i)
        visited[i] = True
 

n, m, start = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(n+2)]
# 0번째 칸은 공란, graph[1] : 점 1과 연결된 점
visited_dfs = [False]*(n+1)
visited_bfs = [False]*(n+1)

for _ in range(m):
  v1, v2 = map(int, sys.stdin.readline().split())
  graph[v1].append(v2)
  graph[v2].append(v1)

for i in graph:
  i.sort()

dfs(graph, start, visited_dfs)
print(' '.join(map(str, dfs_arr)))
bfs(graph, start, visited_bfs)
print(' '.join(map(str, bfs_arr)))
