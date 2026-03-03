#Baekjoon_1931

import sys

def maxMeeting(schedule):
  # greedy, 종료시간이 빠른 순서로 시간을 합치면 최적의 결과
  count = 1
  end_time = schedule[0][1]
  for i in range(1,len(schedule)):
    if end_time <= schedule[i][0]:
      count += 1
      end_time = schedule[i][1]
  return count

schedule = list()
for i in range(int(sys.stdin.readline())):
  schedule.append(list(map(int, sys.stdin.readline().split())))

schedule.sort(key = lambda x:x[0])
schedule.sort(key = lambda x:x[1])
# 시작시간으로 정렬 후 종료시간으로 정렬
# 최종적으로 종료시간으로 정렬, 종료시간이 같을경우 시작시간 순서

print(maxMeeting(schedule))
