#Baekjoon_1764

import sys

n,m = map(int, sys.stdin.readline().split())
hear, see = list(), list()
for _ in range(n):
  hear.append(sys.stdin.readline().strip())
for _ in range(m):
  see.append(sys.stdin.readline().strip())

result = sorted(list(set(hear).intersection(see)))
# set 교집합
print(len(result))
print('\n'.join(result))
