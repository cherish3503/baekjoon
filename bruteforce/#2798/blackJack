# Baekjoon_2798

import sys

def sumCard(card, sumT, k, depth):
  if depth == 3:
    result = sum(sumT)
    if result <= m:
      sumL.append(result)
    return

  for i in range(k,len(card)):
    sumT.append(card[i])
    sumCard(card, sumT, i+1, depth+1)
    sumT.pop()


n,m = map(int, sys.stdin.readline().split())
card = list(map(int, sys.stdin.readline().split()))

sumL = list()
sumTemp = list()

sumCard(card, sumTemp, 0, 0)
print(max(sumL))

