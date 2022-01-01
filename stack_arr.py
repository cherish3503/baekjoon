#Baekjoon_1874

import sys

def stack_arr(arr):
    init = list(range(1, len(arr) + 1))
    stack = list()
    result = list()
    # push = 0, pop = 1
    tmp = 0

    for i in arr:
      if tmp > i:
        while True:
          result.append('-')
          if stack.pop() == i:
            break
          else:
            return -1
      else:
        while True:
          tmp = init.pop(0)
          result.append('+')
          stack.append(tmp)
          if tmp == i:
            result.append('-')
            stack.pop()
            break
        
    return result


arr = list()
for _ in range(int(sys.stdin.readline())):
  arr.append(int(sys.stdin.readline()))

result = stack_arr(arr)
if result != -1:
  print('\n'.join(result))
else:
  print("NO")

