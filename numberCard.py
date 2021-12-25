#Baekjoon_10815

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
cardL = sorted(list(map(int, sys.stdin.readline().split())))
sys.stdin.readline()

arr = list(map(int, sys.stdin.readline().split()))
for i in arr:
    if binary_search(cardL,i) != -1:
        print(1, end = ' ')
    else:
        print(0, end = ' ')
