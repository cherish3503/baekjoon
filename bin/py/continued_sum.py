#Baekjoon_1912

import sys

n = int(sys.stdin.readline())
num = list(map(int, sys.stdin.readline().split()))
dp = [0] * n

dp[0] = num[0]
for i in range(1,len(num)):
  dp[i] = max(dp[i-1] + num[i], num[i])
  # 구간 합이 끊겼다는 것은 그 구간의 합이 0보다 작다는 뜻 == 그 구간을 더하는것에 이득이 없음
  # num[i-1]을 포함한 구간합의 최대 값 : dp[i-1]
  # num[i]를 포함한 구간합의 최대 : dp[i]

print(max(dp))
