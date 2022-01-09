#Baekjoon_14889

import sys

n = int(sys.stdin.readline())
s_ij = list()
for _ in range(n):
  s_ij.append(list(map(int, sys.stdin.readline().split())))
visited = [False] * n
arr = list()
diff = list()

def combine(n, m, k, depth):
  if depth == m:
    # m개를 모두 탐색
    
    diff.append(diff_arr(arr))
    return

  else:
    for i in range(k,n):
      # 이전의 포함 되는 경우를 제외하여 점점 작아지는 반복, 반복하면서 이미 포함되어 있는지 순서대로 체크
      if not visited[i]:
        # ex) visited[0] = 1이 포함되어있는지
        if depth == 0 and i != 0:
          # 1을 포함한 조합만 고려하면 반대쪽은 1을 포함하지 않는 집합이므로 모든 경우를 고려
          return
        visited[i] = True
        arr.append(i+1)
        combine(n,m,i+1,depth+1)
        # depth당 한개의 원소를 추가
        visited[i] = False
        arr.pop()
        # 한 번 배열을 완성한 후 한 depth씩 올라가면서 체크

def diff_arr(arr):
  sum = 0
  for i in arr:
    for k in arr:
      sum += s_ij[i-1][k-1]

  arr_difference = list(set(range(1,n+1)) - set(arr))
  # 차집합 : 1~n까지의 집합에서 arr을 뺌
  sum_difference = 0
  for i in arr_difference:
    for k in arr_difference:
      sum_difference += s_ij[i-1][k-1]
  
  return abs(sum - sum_difference)

combine(n, n//2, 0, 0)
print(min(diff))



