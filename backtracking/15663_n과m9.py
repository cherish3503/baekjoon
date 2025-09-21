import itertools
import sys

n, m = map(int, sys.stdin.readline().split())
inp = list(map(int, sys.stdin.readline().split()))
# inp.sort()

# print(inp)

comb = list(set(itertools.permutations(inp, m)))
comb.sort()

for c in comb:
    print(" ".join(map(str,c)))
