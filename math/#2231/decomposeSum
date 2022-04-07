# Baekjoon_2231

n = int(input())

for i in range(1,n+1):
  
  if i == n:
    print(0)
    break
  
  j = i # j는 10으로 나눠질 수
  sum = j # 그 수 자체를 먼저 합함
  while j > 0:
    sum += j%10
    j //= 10
  if sum == n: # 생성자를 찾은 경우
    print(i)
    break
