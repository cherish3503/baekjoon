#Baekjoon_10773

arr = list()
for i in range(int(input())):
    inp = int(input())
    if inp != 0:
        arr.append(inp)
    else:
        del arr[len(arr)-1]

sum = 0
for i in arr:
    sum += i
    
print(sum)

    
