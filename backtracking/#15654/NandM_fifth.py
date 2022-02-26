# Baekjooon_15654

import sys

def NandM(arr,result,depth,v,visited):
  # sorted arr
  if depth == m:
    print(' '.join(map(str, result)))
    return
  
  for i in range(len(arr)):
    if not visited[i]:
      result.append(arr[i])
      visited[i] = True
      NandM(arr,result,depth+1,i,visited)
      result.pop()
      visited[i] = False

n, m = map(int, sys.stdin.readline().split())
arr = sorted(list(map(int, sys.stdin.readline().split())))
result = list()
visited = [False]*len(arr)
NandM(arr,result,0,0,visited)
