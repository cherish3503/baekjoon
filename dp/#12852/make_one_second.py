# Baekjoon_12852

import sys
sys.setrecursionlimit(10**6)

def makeOne(n):
  # 이미 만들어진 dp에서 숫자를 구하는 순서를 리턴
  arr.append(n)
  if n == 1:
    return 0
    
  result = list()
  if n%3 == 0:
    result.append(n//3)
  if n%2 == 0:
    result.append(n//2)
  result.append(n-1)

  min_ = result[0]
  for i in result:
    if dp[i] <= dp[min_]:
      min_ = i
      
  makeOne(min_)
    
n = int(input())
dp = [0 for _ in range(n+1)]
arr = list()

for x in range(2,n+1): # dp[1] = 0
  # bottom-up
  dp[x] = dp[x-1]+1
  if x%3 == 0:
    dp[x] = min(dp[x//3]+1,dp[x])
  if x%2 == 0:
    dp[x] = min(dp[x//2]+1,dp[x])

print(dp[n])
makeOne(n)
print(' '.join(map(str, arr)))
