def selfNumber(n):
    selfN = list(range(1,n+1))
    for i in range(1,n+1):
        d_n = i
        for j in str(i):
            d_n += int(j)

        if d_n in selfN:
            selfN.remove(d_n)

    return selfN
    
                       
for i in selfNumber(10000):
    print(i)
