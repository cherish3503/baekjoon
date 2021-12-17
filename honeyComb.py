#Baekjoon_2292

def honeyComb(n):
    if n == 1:
        return 1
    
    elif n > 1:
        i = 1
        while True:
            if n < (3*i*(i+1) + 2):
                return i+1
            
            i+=1
            
print(honeyComb(int(input())))
