# Baekjooon_4948

import sys

def bertrand(n):
  prime = [False, False] + [True]*(2*n-1)
  for i in range(2, int(2*n ** 0.5)+1):
    if prime[i]:
      for j in range(2*i, 2*n+1, i):
        prime[j] = False
  
  return [i for i in range(n+1,2*n+1) if prime[i] == True]

while(True):
  n = int(sys.stdin.readline())
  if n == 0:
    break

  print(len(bertrand(n)))
