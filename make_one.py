#Baekjoon_1463

def make_one(n):
  # Botton-up
  # Top-down 으로 구현할 경우 메모리 초과 
  if n == 1:
    return 0
  elif n == 2 or n == 3:
    return 1
  
  d = [0] * (n+1)
  d[1], d[2], d[3] = 0,1,1
  
  for k in range(4,n+1):
    result = list()
    if k%3 == 0:
      result.append(d[k//3])
    if k%2 == 0:
      result.append(d[k//2])
    result.append(d[k-1])
    d[k] = min(result)+1
    
  return d[n]

print(make_one(int(input())))

