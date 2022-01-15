#Baekjoon_11053

import sys

def lis(arr):
  # Longest Increasing Subsequence
  for i in range(len(arr)):
    for j in range(len(arr[:i])):
      # len(arr[:i]) = i
      if arr[i] > arr[j] and dp[i] < dp[j]:
        dp[i] = dp[j]
        # 매 반복마다 그 앞 원소들의 dp들과 모두 비교
        # 값이 더 크고 dp가 더 작을때 dp 값을 복사해온다.
    dp[i] += 1
    # 증가하는 수열의 길이가 하나 더 길어짐
  return max(dp)

n = int(sys.stdin.readline())
dp = [0]*n

print(lis(list(map(int, sys.stdin.readline().split()))))
