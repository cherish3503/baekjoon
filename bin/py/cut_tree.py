#Baekjoon_2805

import sys

def cut_tree(m,tree):
    #반대로 정렬된 배열 tree
    
    start, end = 0, tree[0]
    result = start
    
    while start <= end:
        mid = (start + end) // 2
        sum = 0
        for t in tree:
            if sum >= m:
                break
            elif t-mid > 0:
                sum += t-mid
            else:
                break
        if sum >= m:
            start = mid + 1
            result = mid
        else:
            end = mid -1
    
    return result
    
    
        
n, m = map(int, sys.stdin.readline().split())
arr = list(map(int,sys.stdin.readline().split()))
arr.sort(reverse = True)
print(cut_tree(m,arr))
