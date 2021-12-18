#Baekjoon_1181

def merge_sort_str(arr):
    if len(arr) < 2:
        return arr

    mid = len(arr) // 2
    low_arr = merge_sort_str(arr[:mid])
    high_arr = merge_sort_str(arr[mid:])

    merged_arr = []
    l = h = 0
    while l < len(low_arr) and h < len(high_arr):
        if (len(low_arr[l]) < len(high_arr[h])) or ((len(low_arr[l]) == len(high_arr[h])) and (low_arr[l] < high_arr[h])) :
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
    inp = input()
    if inp not in arr:
        arr.append(inp)

arr = merge_sort_str(arr)

for i in arr:
    print(i)
