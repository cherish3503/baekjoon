#Baekjoon_2839

def sugar_delivery(n):
    n_5 = n //5
    # 5kg 봉지가 많을 수록 최소이므로 5kg 봉지를 줄이면서 반복
    for i in range(n_5,-1,-1):
        if (n - 5*i)%3 == 0:
            return i + (n - 5*i)//3
    return -1
   
print(sugar_delivery(int(input())))
