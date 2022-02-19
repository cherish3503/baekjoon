# Baekjoon_9251
# dp

a = input()
b = input()
lcs = [[0 for _ in range(len(b)+1)] for _ in range(len(a)+1)]

# 행렬 첫 행,열은 0으로 추가, 더하기 위해서

for i in range(len(a)):
  for j in range(len(b)):
    if a[i] == b[j]:
      lcs[i+1][j+1] = lcs[i][j] + 1
    else:
      lcs[i+1][j+1] = max(lcs[i][j+1], lcs[i+1][j])

print(lcs[-1][-1])
