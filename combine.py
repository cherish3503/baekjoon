#Baekjoon_15649

n, m = map(int, input().split())
visited = [False] * n
arr = list()

def combine(n, m, depth):
  if depth == m:
    # m개를 모두 탐색
    print(' '.join(map(str,arr)))
    return

  else:
    for i in range(n):
      # n개의 원소를 반복하면서 이미 포함되어 있는지 순서대로 체크
      if not visited[i]:
        # ex) visited[0] = 1이 포함되어있는지
        visited[i] = True
        arr.append(i+1)
        combine(n,m,depth+1)
        # depth당 한개의 원소를 추가
        visited[i] = False
        arr.pop()
        # 한 번 배열을 완성한 후 한 depth씩 올라가면서 체크

combine(n,m,0)
