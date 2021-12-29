#Baekjoon_2193

d = [(0,0)] * 91
def pinary_number(n):
  if n == 1:
    return (0,1)
  elif d[n] != (0,0):
    return d[n]
  
  else:
    d[n] = (pinary_number(n-1)[0]+pinary_number(n-1)[1], pinary_number(n-1)[0])
    return d[n]

print(sum(pinary_number(int(input()))))
