#Baekjoon_11659

import sys

n, m = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
sum_List = arr
for i in range(1,len(arr)):
  sum_List[i] += sum_List[i-1]

for _ in range(m):
  start, end = map(int, sys.stdin.readline().split())
  if start == 1:
    print(sum_List[end-1])
  else:
    print(sum_List[end-1] - sum_List[start-2])
  # print(sum(arr[start-1:end])) -> TLE
