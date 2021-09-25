# Baekjoon_1065

def hanNumber(n):
    count = 0
    for i in range(1,n+1):
        if i < 10:
            count += 1

        elif i < 100:
            count += 1
            
        else:
            dif = int(str(i)[0]) - int(str(i)[1])
            check = False
            for j in range(len(str(i))-1):
               if int(str(i)[j]) - int(str(i)[j+1]) is not dif:
                   check = True
                   break
            if not check:
                count += 1
                check = False
                


    return count

print(hanNumber(int(input())))
