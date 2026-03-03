#Baekjoon_2630

import sys

sum = [0,0]

def square_cut(square):
  global sum
  color = square[0][0]
  break_ = False
  for i in square:
    if break_:
      break
    for j in i:
      if j != color:
        break_ = True
        break
  if not break_:
    sum[color] += 1
    # 함수의 끝 부분에서만 결과 수정
    return

  if break_:
    square_top = square[0:len(square)//2]
    square_bot = square[len(square)//2:len(square)]
    # 우선 2*4 크기의 윗 부분과 아랫 부분으로 분할 

    square_cutted = [[] for _ in range(4)]
    for i in range(len(square_top)):
      square_cutted[0].append((square_top[i])[0:len(square)//2])
    for i in range(len(square_top)):
      square_cutted[1].append((square_top[i])[len(square)//2:len(square)])

    for i in range(len(square_top)):
      square_cutted[2].append((square_bot[i])[0:len(square)//2])
    for i in range(len(square_top)):
      square_cutted[3].append((square_bot[i])[len(square)//2:len(square)])
    # 4개의 정사각형으로 slicilng

    for i in square_cutted:
      square_cut(i)

square = list()
for _ in range(int(sys.stdin.readline())):
  square.append(list(map(int, sys.stdin.readline().split())))

square_cut(square)
for i in sum:
  print(i)
