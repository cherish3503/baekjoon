# Baekjoon_1629
# (a*b) mod n = ((a mod n)*(b mod n)) mod n
# dp

import sys
import math

def aPowerbModc(a,b,c):
  dp[0] = a%c
  for i in range(1,int(math.log2(b))+1):
    dp[i] = (dp[i-1]**2)%c
    # dp[n] = ((a mod c)^(2^n)) mod c

  result = 1
  j = 0
  while(b>0):
    if b%2 == 1:
      result *= dp[j]
      result %= c
    b //= 2
    j += 1
  # b를 2진수로 변환 후 해당하는 dp 값을 곱함.

  return result

a,b,c = map(int,sys.stdin.readline().split())
dp = [0 for _ in range(int(math.log2(b))+1)]

print(aPowerbModc(a,b,c))
