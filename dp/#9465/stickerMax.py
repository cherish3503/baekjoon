# Baekjoon_9465
# dp

import sys
inv = [1,0]

def stickerMax(sticker):
  # 어떤 한 칸을 선택 했을때 무조건 그 전 혹은 전전 열을 선택해야만 한다.
  # 전 열인 경우 - 대각선 방향
  # 전전 열인 경우 - 같은 행인 경우 이전 열에서 대각선방향을 선택해야만 하므로 다른 행
  # 따라서 두 칸을 포함한 최댓값에 더해주면 된다.
  # 마지막 열의 경우 무조건 선택해야만 하므로 이 두 dp 값을 비교
  if(len(sticker[0]) < 2):
    return max(dp[0][0],dp[1][0])
    # 2x1인 경우
    
  dp[0][1] += dp[1][0]
  dp[1][1] += dp[0][0]
  for col in range(2,len(sticker[0])):
    for row in range(2):
      dp[row][col] += max(dp[inv[row]][col-1],dp[inv[row]][col-2])
  return max(dp[0][-1], dp[1][-1])

for _ in range(int(input())):
  n = int(input())
  sticker = list()
  for _ in range(2):
    sticker.append(list(map(int, sys.stdin.readline().split())))
  dp = sticker.copy()
  print(stickerMax(sticker))
