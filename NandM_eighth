# Baekjooon_15657

import sys

def NandM(arr,result,depth,v):
  # sorted arr
  if depth == m:
    print(' '.join(map(str, result)))
    return
  
  for i in range(v,len(arr)):
      result.append(arr[i])
      NandM(arr,result,depth+1,i)
      result.pop()

n, m = map(int, sys.stdin.readline().split())
arr = sorted(list(map(int, sys.stdin.readline().split())))
result = list()
NandM(arr,result,0,0)
