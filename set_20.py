#Baekjoon_11723

import sys

# Bitmask
# set을 이진수로 관리
class Set_20:
  def __init__(self):
    self.data = 0
  
  def bin(self, x):
    return 1 << x-1
  
  def add(self, x):
    self.data |= self.bin(x)

  def remove(self, x):
    self.data &= ~self.bin(x)

  def check(self, x):
    if (self.data & self.bin(x) == self.bin(x)):
       return True
    else:
      return False

  def toggle(self, x):
    self.data ^= self.bin(x)

  def all(self):
    self.data |= 2**20-1

  def empty(self):
    self.data &= 0

s = Set_20()
for _ in range(int(sys.stdin.readline())):
  inp = sys.stdin.readline().split()
  if len(inp) == 1:
    getattr(s, inp[0])()
  else:
    if inp[0] == 'check':
      if getattr(s, inp[0])(int(inp[1])):
        print(1)
      else:
        print(0)
    else:
      getattr(s, inp[0])(int(inp[1]))
