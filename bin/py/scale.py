#Baekjoon_2920

asc = list(range(1,9))
des = list(range(8,0, -1))
arr = list(map(int, input().split()))
if arr == asc:
    result = "ascending"
elif arr == des:
    result = "descending"
else:
    result = "mixed"
    
print(result)
