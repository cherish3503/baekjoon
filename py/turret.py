#Baekjoon_1002

def turret(x1,y1,r1,x2,y2,r2):
    if pow(x1-x2,2) + pow(y1-y2,2) > pow(r1+r2,2):
        #두 원이 만나지 않을때
        return 0
    elif pow(x1-x2,2) + pow(y1-y2,2) == pow(r1+r2,2):
        #두 원이 외접할때
        return 1
    
    elif x1 == x2 and y1 == y2 and r1 == r2:
        #두 원이 같은 원
        return -1
    
    elif pow(x1-x2,2) + pow(y1-y2,2) == pow(r1-r2,2):
        #두 원이 내접할때
        return 1
    elif pow(x1-x2,2) + pow(y1-y2,2) < pow(r1-r2,2):
        #한 원 안에 다른 원
        return 0
    
    else:
        return 2
    
for i in range(int(input())):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    print(turret(x1,y1,r1,x2,y2,r2))
    



    
