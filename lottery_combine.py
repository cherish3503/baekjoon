# Baekjooon_6603

import sys
sys.setrecursionlimit(10**6)
limit = 6

def combination(arr, result, depth, k, limit, visited):
  if depth == limit:
    print(' '.join(map(str, result)))
    return

  for i in range(k, len(arr)):
    if not visited[i]:
      visited[i] = True
      result.append(arr[i])
      combination(arr, result, depth+1, i+1, limit, visited)
      result.pop()
      visited[i] = False
      

while(True):
  inp = list(map(int, sys.stdin.readline().split()))

  if inp[0] == 0:
    break # 탈출조건

  del inp[0]
  result = list()
  visited = [False]*len(inp)

  combination(inp, result, 0, 0, limit, visited)
  print()
