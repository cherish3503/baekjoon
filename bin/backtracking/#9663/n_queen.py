# Baekjoon_9663

n = int(input())
col = [True]*n
diagonal_1 = [True]*(2*n)
diagonal_2 = [True]*(2*n)
count = 0

def n_queen(col, diagonal_1, diagonal_2, r):
  if r == n:
    global count
    count += 1
    return
    
  for c in range(n):
    if col[c] and diagonal_1[r+c] and diagonal_2[r-c]:
      col[c] = False
      diagonal_1[r+c] = False
      diagonal_2[r-c] = False
      n_queen(col, diagonal_1, diagonal_2, r+1)
      col[c] = True
      diagonal_1[r+c] = True
      diagonal_2[r-c] = True

n_queen(col, diagonal_1, diagonal_2, 0)
print(count)
