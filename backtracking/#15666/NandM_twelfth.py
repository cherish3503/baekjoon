# Baekjoon_15666
# backtracking

import sys

def NandM_twelfth(arr, result, k, depth):
  if depth == m:
    print(' '.join(map(str, result)))
    return

  for i in range(k,len(arr)):
    result.append(arr[i])
    NandM_twelfth(arr, result, i, depth+1)
    result.pop()

n,m = map(int, sys.stdin.readline().split())
arr = sorted(list(set(map(int, sys.stdin.readline().split()))))

NandM_twelfth(arr, list(), 0, 0)
