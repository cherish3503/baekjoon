#Baekjoon_10799

def iron_stick(inp):
  iron = 0
  sum = 0

  for i in range(len(inp)):
    if inp[i] == '(':
      iron += 1

    elif inp[i] == ')':
      iron -= 1
      if inp[i-1] == '(':
        sum += iron
      else:
        sum += 1
  
  return sum

print(iron_stick(input()))
