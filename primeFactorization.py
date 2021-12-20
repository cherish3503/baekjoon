#Baekjoon_11653

def primeFactorization(n):
    i = 2
    primeF = list()

    if n == 1:
        return primeF

    
    while(1):
        if n==i:
            primeF.append(i)
            return primeF
        
        elif i*i > n:
            primeF.append(n)
            return primeF
            
        elif n%i == 0:
            primeF.append(i)
            n //= i
        else:
            i += 1


arr = primeFactorization(int(input()))
for i in arr:
    print(i)
