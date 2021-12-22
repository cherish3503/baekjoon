#Baekjoon_9012

def isVPS(str):
    open = 0
    for i in str:
        if i == '(':
            open += 1
        elif i == ')':
            if open > 0:
                open -= 1
            else:
                return False
    
    if open == 0:
        return True
    else:
        return False
    

for i in range(int(input())):
    if isVPS(input()):
        print('YES')
    else:
        print('NO')
