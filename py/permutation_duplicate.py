#Baekjoon_15651

n, m = map(int, input().split())
visited = [False] * n
arr = list()

def permutation_dupl(n, m, depth):
  if depth == m:
    # m개를 모두 탐색
    print(' '.join(map(str,arr)))
    return

  else:
    for i in range(n):
        arr.append(i+1)
        permutation_dupl(n,m,depth+1)
        # depth당 한개의 원소를 추가
        arr.pop()
        # 한 번 배열을 완성한 후 한 depth씩 올라가면서 체크

permutation_dupl(n,m,0)
