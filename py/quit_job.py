#Baekjoon_14501

import sys

d = list()

def quit_job(profit):
  for i in range(len(profit)-1,-1,-1):

    if i == len(profit)-1:
      # 마지막 날
      if profit[i][0] == 1:
        d[i] = profit[i][1]
        # 마지막 날 상담기간이 1이면
      else:
        d[i] = 0
    elif i + profit[i][0] == len(profit):
      # 기간이 마지막날까지
      d[i] = max(profit[i][1] ,d[i+1])

    elif i + profit[i][0] > len(profit):
      # index 초과 방지
        # 마지막날이 아닌 경우
        d[i] = max(0,d[i+1])

    else:
      d[i] = max(profit[i][1] + d[i+profit[i][0]], d[i+1])
  
  return d[0]
  

n = int(sys.stdin.readline())
d = [0] * n
profit = list()
for i in range(n):
  profit.append(list(map(int,sys.stdin.readline().split())))

print(quit_job(profit))
