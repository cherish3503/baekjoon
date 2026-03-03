#Baekjoon_1712

import math

def BE_Point(f_cost,v_cost,price):
    if v_cost >= price:
        return -1
    else :
        return math.floor((f_cost / (price - v_cost)) + 1)

n1, n2, n3 = map(int,input().split())
bePoint = BE_Point(n1,n2,n3)
print(bePoint)
