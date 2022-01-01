#Baekjoon_2606

import sys

graph = list()
visited = list()
arr = list()

def dfs(graph, v, visited):
  visited[v] = True
  arr.append(v)
  for i in graph[v]:
    if not visited[i]:
     dfs(graph, i, visited)




vertex = int(sys.stdin.readline())
visited = [False] * (vertex+1)
graph = [[] for _ in range(vertex+1)]
for _ in range(int(sys.stdin.readline())):
  v1,v2 = map(int, sys.stdin.readline().split())
  graph[v1].append(v2)
  graph[v2].append(v1)

dfs(graph, 1, visited)
print(len(arr)-1)
