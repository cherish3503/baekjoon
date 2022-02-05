# Baekjoon_1149

import sys

n = int(input())
dp = [[0 for _ in range(3)] for _ in range(n+1)]
rgb_list = [[1,2],[0,2],[0,1]] 

dp[1] = list(map(int,sys.stdin.readline().split()))
# index error 방지
for i in range(2,n+1):
  dp[i] = list(map(int,sys.stdin.readline().split()))
  for rgb in range(len(rgb_list)):
    dp[i][rgb] += min(dp[i-1][rgb_list[rgb][0]],dp[i-1][rgb_list[rgb][1]])
    # 다른 색을 가진 이전 집의 최솟값을 더함. 

print(min(dp[n]))
