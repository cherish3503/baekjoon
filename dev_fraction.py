#Baekjoon_1193

def fraction(n):
    i = 1
    count = 2
    
    while True:
        if n-i <= 0:
            break
        else:
            n = n-i
            count += 1
        
        i = i+1
    n1 = n
    n2 = count - n1
    if count%2 == 1:
        return n1,n2
    else:
        return n2,n1

num, den = fraction(int(input()))

print("%d/%d" %(num, den))
