import sys
import heapq

# 다익스트라를 사용하여 x에서 출발하는 최단거리와 x로 도착하는 최단거리를 구한다.
# vertex방향만 바꿔준다.

INF = float('inf')

def dijkstra(start, n, edgeList):
    distance = [INF for _ in range(n + 1)]  # 1~n
    distance[start] = 0

    pq = [[0,start]]

    while pq:
        dist, vertex = heapq.heappop(pq)

        if dist > distance[vertex]:
            continue

        for toVertex, weight in edgeList[vertex]:
            new_dist = distance[vertex] + weight
            if new_dist < distance[toVertex]:
                distance[toVertex] = new_dist
                heapq.heappush(pq, [new_dist, toVertex])

    return distance

# def getMax(arr):
#     max = 0
#     for e in arr:
#         if e == INF:
#             continue
#         if e > max:
#             max = e
#     return max

n, m, x = map(int, sys.stdin.readline().split())

edgeForthList = [[] for _ in range(n+1)]
edgeBackList = [[] for _ in range(n+1)]

for i in range(m):
    from_, to, time = map(int, sys.stdin.readline().split())
    edgeForthList[from_].append([to, time])
    edgeBackList[to].append([from_, time])

forthResult = dijkstra(x, n, edgeForthList)
backResult = dijkstra(x, n, edgeBackList)
result = [x+y for x,y in zip(forthResult, backResult)]
# print(forthResult)
# print(backResult)


print(max(result[1:]))














