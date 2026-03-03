#Baekjoon_1920

import sys

def binary_search(arr, value):
    low, high = 0, len(arr) -1

    while (low <= high):
        mid = (low + high) // 2
        if arr[mid] > value:
            high = mid - 1

        elif arr[mid] < value:
            low = mid + 1 

        elif arr[mid] == value:
            return mid
        
    return -1
    
    

sys.stdin.readline()
arr = list(map(int, sys.stdin.readline().split()))
arr.sort()


sys.stdin.readline()
for i in list(map(int, sys.stdin.readline().split())):
    if binary_search(arr, i) == -1:
        print(0)
    else:
        print(1)



    
