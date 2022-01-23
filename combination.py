# Baekjooon_2407

# nCm = n-1Cm-1 + n-1Cm

def combination(n, r):
  for i in range(1,len(dp)):
    for j in range(1,len(dp[i])-1):
      dp[i][j] = dp[i-1][j-1] + dp[i-1][j]

  return dp[n][r]

n, r = map(int, input().split())
dp = [[1]*(i+1) for i in range(n+1)]

print(combination(n,r))
