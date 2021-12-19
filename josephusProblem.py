#Baekjoon_1158

def josephusProblem(arr,n):
    josephus = list()
    tmp = 0
    for i in range(len(arr)):
        tmp = (tmp + n -1) % len(arr)
        josephus.append(arr.pop(tmp))

    return josephus

n,k = map(int,input().split())
result = josephusProblem(list(range(1,1+n)),k)

print('<', end = '')
for i,e in enumerate(result):
    if i != len(result)-1:
        print(e, end=', ')
    else:
        print(e, end='>')
