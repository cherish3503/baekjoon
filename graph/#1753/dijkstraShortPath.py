# Baekjoon_1753
# graph, greedy
# 최단거리순으로 더해가는 과정이므로 한번 확정난 거리(heap에서 나옴)는 최단거리.

import heapq
import sys

def dijkstra(start):
  heap = []
  heapq.heappush(heap, (0,start)) # (이동거리, 도착지점)
  distance[start] = 0

  while heap:
    dist, now = heapq.heappop(heap)

    if distance[now] < dist:
      # 이미 확정된 도착지점은 다시 고려할 필요 x
      continue
    
    for i in graph[now]:
      cost = dist + i[1]
      if cost < distance[i[0]]:
        distance[i[0]] = cost
        heapq.heappush(heap, (cost, i[0]))


INF = int(1e9) # 10억
v,e = map(int, sys.stdin.readline().split())
start = int(input())
distance = [INF]*(v+1)
graph = [[] for i in range(v+1)]

for i in range(e):
  a,b,d = map(int, sys.stdin.readline().split())
  graph[a].append((b,d)) # u->v로 가는 가중치 w

dijkstra(start)

for i in range(1, v+1):
  if distance[i] == INF:
    print("INF")
  else:
    print(distance[i])
