#Baekjoon_11650

def merge_sort_coordinate(arr):
    if len(arr) < 2:
        return arr

    mid = len(arr) // 2
    low_arr = merge_sort_coordinate(arr[:mid])
    high_arr = merge_sort_coordinate(arr[mid:])

    merged_arr = []
    l = h = 0
    while l < len(low_arr) and h < len(high_arr):
        if (low_arr[l][0] < high_arr[h][0]) or ((low_arr[l][0] == high_arr[h][0]) and (low_arr[l][1] < high_arr[h][1])) :
            merged_arr.append(low_arr[l])
            l += 1

        else:
            merged_arr.append(high_arr[h])
            h += 1
    merged_arr += low_arr[l:]
    merged_arr += high_arr[h:]
    return merged_arr


arr = list()
for i in range(int(input())):
    arr.append(list(map(int,input().split())))
    
arr = merge_sort_coordinate(arr)

for i in arr:
    print('%d %d' %(i[0],i[1]))

