#Baekjoon_1931
# 시작시간이 같은 경우 종료시간이 빠른 한 가지만 제외하고 삭제
# 시작시간 순서로 sorting 후 dp로 계산

import sys

def merge_sort(arr):
    # 이차원 배열, 배열의 첫번째 원소를 기준으로 sort
    # 첫번째 원소가 같은경우 두번째 원소가 더 작은 것만 배열에 삽입
    if len(arr) < 2:
        return arr

    mid = len(arr) // 2
    low_arr = merge_sort(arr[:mid])
    high_arr = merge_sort(arr[mid:])

    merged_arr = []
    l = h = 0
    while l < len(low_arr) and h < len(high_arr):
      if low_arr[l][0] < high_arr[h][0]:
        # 첫번째 원소끼리 비교
        merged_arr.append(low_arr[l])
        l += 1

      elif low_arr[l][0] == high_arr[h][0]:
        # 첫번째 원소가 같은경우 두번째 원소가 더 작은 것만 배열에 삽입
        if low_arr[l][1] <= high_arr[h][1]:
          merged_arr.append(low_arr[l])
        else:
          merged_arr.append(high_arr[h])
        l += 1
        h += 1
          
      else:
        merged_arr.append(high_arr[h])
        h += 1
    merged_arr += low_arr[l:]
    merged_arr += high_arr[h:]
    return merged_arr


def maxMeeting(schedule):
  for i in range(0,len(schedule)):
    for j in range(len(schedule[:i])):
      if schedule[i][0] >= schedule[j][1] and dp[i] < dp[j]:
        # 구하는 것의 시작시간이 이전의 종료시간보다 같거나 늦을때
        dp[i] = dp[j]
    dp[i] += 1
  return max(dp)
schedule = list()
for i in range(int(sys.stdin.readline())):
  schedule.append(list(map(int, sys.stdin.readline().split())))

schedule = merge_sort(schedule)
dp = [0 for _ in range(len(schedule))]

print(maxMeeting(schedule))
