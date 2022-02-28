# Baekjoon_2475

arr = list(map(int, input().split()))
result = 0
for i in arr:
  result += i**2 % 10
print(result % 10)
