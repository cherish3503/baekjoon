#Baekjoon_1912

import sys

n = int(sys.stdin.readline())
num = list(map(int, sys.stdin.readline().split()))
dp = [0] * n

dp[0] = num[0]
for i in range(1,len(num)):
  dp[i] = max(dp[i-1] + num[i], num[i])
  # num[i-1]을 포함한 구간합의 최대 값 : dp[i-1]
  # num[i]를 포함한 구간합의 최대 : dp[i]

print(max(dp))
