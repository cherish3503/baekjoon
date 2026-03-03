#Baekjoon_1654

import sys
import math

lan = list()

def check_lan(n):
  sum = 0

  for i in lan:
    sum += math.floor(i // n)

  return sum

def upper_bound(n, value):
  # 조건을 만족하는 최대값을 구함
  low, high = 1, n

  result = 1
  

  while low <= high:
      mid = (low + high) // 2
      if m <= check_lan(mid):
          low = mid + 1
          result = mid
          # 조건을 만족하는 경우 값을 result에 대입
      else:
          high = mid - 1
  return result

n, m = map(int, sys.stdin.readline().split())

for _ in range(n):
  lan.append(int(sys.stdin.readline()))

print(upper_bound(max(lan), m))
