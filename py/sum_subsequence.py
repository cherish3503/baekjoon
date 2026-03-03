# Baekjooon_1182

import sys

count = 0
def sum_subsequence(arr, result, k):
  if k == len(arr):
    if sum(result) == s and len(result) != 0:
      global count
      count += 1
    return
  
  sum_subsequence(arr, result, k+1)
  result.append(arr[k])
  sum_subsequence(arr, result, k+1)
  result.pop()

n, s = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
result = []
sum_subsequence(arr, result, 0)

print(count)
