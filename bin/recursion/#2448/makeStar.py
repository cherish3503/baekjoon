
# Baekjoon_2448
# dp

import math
def makeStar(n):
  
  star.append(['  *  ',' * * ','*****'])
  
  for k in range(1,n+1):
    listT = list()
    
    for i in range(len(star[k-1])):
      listT.append(' '*3*2**(k-1) + star[k-1][i] + ' '*3*2**(k-1))
    for i in range(len(star[k-1])):
      listT.append(star[k-1][i] + ' ' + star[k-1][i])

    star.append(listT)
  
star = list()

n = int(input())
n = int(math.log2(n//3))

makeStar(n)

for i in range(len(star[n])):
  print(star[n][i])
