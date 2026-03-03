#Baekjoon_2908
num = input().split()


sangsu0 = int(''.join(reversed(num[0])))
sangsu1 = int(''.join(reversed(num[1])))
sangsu = sangsu0 if (sangsu0 > sangsu1) else sangsu1

print(sangsu)
