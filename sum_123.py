#Baekjoon_9095

import math
import sys

def sum_123(n):
    sum = 0
    for i in range(n//3 +1):
        t = n - 3*i 
        for j in range(t//2 +1):
            #[t-2*j,j,i]
            # 같은 것이 있는 순열
            sum += math.factorial(t-2*j + j + i)//math.factorial(t-2*j)//math.factorial(j)//math.factorial(i)
    
    return sum

for i in range(int(sys.stdin.readline())):
    print(sum_123(int(sys.stdin.readline())))
