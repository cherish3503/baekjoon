#Baekjoon_15652

n, m = map(int, input().split())
arr = list()

def permutation_asc(n, m, k, depth):
  if depth == m:
    # m개를 모두 탐색
    print(' '.join(map(str,arr)))
    return

  else:
    for i in range(k,n):
      # 비내리차순으로 depth가 깊어질수록 작아지는 반복
        arr.append(i+1)
        permutation_asc(n,m,i,depth+1)
        # depth당 한개의 원소를 추가
        arr.pop()
        # 한 번 배열을 완성한 후 한 depth씩 올라가면서 체크

permutation_asc(n,m,0,0)
