#Baekjoon_5622

ctoia = [3,3,3,3,3,4,3,4]

def ctoi(chr):
    if(chr.islower()) :
        return(ctoif(ord(chr) - ord('a')))
    else:
        return(ctoif(ord(chr) - ord('A')))
    
def ctoif(n):
    for i,r in enumerate(ctoia):
        if n-r < 0:
            return (i+2)
        else:
            n = n-r
            
ipStr = input()
sum = 0
for i in ipStr:
    sum += 1
    sum += ctoi(i)

print(sum)
