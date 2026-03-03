# Baekjoon_1932
# dp

import sys

def maxTri(arr):
  dp = arr.copy()
  for row in range(1,len(arr)):
    dp[row][0] += dp[row-1][0]
    dp[row][-1] += dp[row-1][-1]
    for col in range(1,len(arr[row])-1):
      dp[row][col] += max(dp[row-1][col-1],dp[row-1][col])
  return max(dp[-1])
  

n = int(input())
arr = list()
for i in range(n):
  arr.append(list(map(int, sys.stdin.readline().split())))

print(maxTri(arr))
