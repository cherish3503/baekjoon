# Baekjoon_1916
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
    # heap에서 처음 나오는 어떤 도착지점으로의 첫 튜플은 그 도착지점으로 가는 가장 낮은 비용이므로(더 작은 수의 합으로 만들 수 없음),
    # 그것으로 도착지점으로 가는 최단 경로가 확정이 됨.

    if distance[now] < dist:
      # 이미 확정된 도착지점은 다시 고려할 필요 x
      continue
    
    for i in graph[now]:
      cost = dist + i[1]
      if cost < distance[i[0]]:
        distance[i[0]] = cost
        heapq.heappush(heap, (cost, i[0]))


INF = int(1e9) # 10억
v = int(input()) # city
e = int(input()) # bus
distance = [INF]*(v+1)
graph = [[] for i in range(v+1)]

for i in range(e):
  a,b,d = map(int, sys.stdin.readline().split())
  graph[a].append((b,d)) # a->b로 가는 가중치 d

start, end = map(int, input().split())

dijkstra(start)

print(distance[end])
