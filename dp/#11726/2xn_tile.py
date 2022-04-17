#Baekjoon_11726

import sys
sys.setrecursionlimit(1001)

d = [0 for i in range(1001)]

def zxn_tile(n):
    if n == 1:
        return 1
    elif n == 2:
        return 2
    
    elif d[n] != 0:
        return d[n]
    else:
        d[n] = zxn_tile(n-1) + zxn_tile(n-2)
        # n인 경우는 / n-1인 경우 * 마지막 세로 / n-2인 경우 * 마지막 가로인 경우의 합이다.
        return d[n]
    
print(zxn_tile(int(input()))%10007)
        
