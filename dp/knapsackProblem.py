# Baekjoon_12865
# 0-1 knapsackProblem (짐을 자를 수 없는경우)

import sys

n, k = map(int, sys.stdin.readline().split()) 
# n: 물건의 수, k: 가방에 들어가는 무게의 합

baggage = list() # (무게, 가치)
for i in range(n):
  baggage.append(list(map(int, sys.stdin.readline().split())))

dp = [[0]*(k+1) for _ in range(n)] # 첫번째 열은 무게가 0
# 행: 각 물건, 열: 최대 무게까지의 정수를 오름차순 정렬

for row in range(len(dp)):
  weight, value = baggage[row][0], baggage[row][1]
  for col in range(len(dp[0])):
    if(col-weight >= 0):
      dp[row][col] = max(dp[row-1][col], dp[row-1][col-weight] + value)
      # dp[row-1] : 현재 row 짐이 들어가지 않은 최대값
      # row = 0 일때, 모든 원소가 0인 마지막 행을 참조
    else:
      dp[row][col] = dp[row-1][col]

print(dp[-1][-1])
