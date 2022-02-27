# Baekjoon_15686

import sys
import itertools

def distChicken(house, chicken):
  # 모든 치킨집과의 거리를 구함
  distance = list()
  for h in house:
    row = list()
    for c in chicken:
      hy,hx,cy,cx = h[0],h[1],c[0],c[1]
      row.append(abs(hx-cx)+abs(hy-cy))
    distance.append(row)
  return distance

def distCity(distance, index):
  # 각 인덱스에 맞는 도시의 치킨거리를 구함
  result = list()
  for i in range(len(distance)):
    result.append(min([distance[i][j] for j in range(len(distance[i])) if j in index]))
    # 인덱스에 맞는 치킨 집과의 거리만 배열에 저장
    # 그 후 가장 가까운 치킨집과의 거리 계산

  return sum(result)

n,m = map(int, sys.stdin.readline().split())
city = list()
for i in range(n):
  city.append(list(map(int, sys.stdin.readline().split())))

house = list()
chicken = list()
for row in range(len(city)):
  for col in range(len(city[0])):
    if city[row][col] == 1:
      house.append((row, col))
    elif city[row][col] == 2:
      chicken.append((row, col))
# 집과 치킨집의 좌표 저장
      
index_arr = list(itertools.combinations(range(len(chicken)), m))
# 조합의 경우의 수를 모두 구함 (tuple)
distCh = list()
for index in index_arr:
  distCh.append(distCity(distChicken(house, chicken), index))
print(min(distCh))
# 도시의 치킨거리의 최솟값
