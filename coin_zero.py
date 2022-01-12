#Baekjoon_11047

import sys

def coin_zero(coin, value):
  count = 0
  
  while coin:
    if value == 0:
      break

    tmp = coin.pop()
    if tmp <= value:
      count += value // tmp
      value %= tmp

  return count

coin = list()
n, value = map(int, sys.stdin.readline().split())
for _ in range(n):
  coin.append(int(sys.stdin.readline()))

print(coin_zero(coin, value))
