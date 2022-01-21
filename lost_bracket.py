# Baekjooon_1541

from collections import deque

def lost_bracket(formula):
  # +,- 로 이루어진 수식의 값을 최소로 하려면 '-'연산을 최대로 하여야 한다.
  # 따라서 '-' 연산 뒤의 다음 '-'연산이 나오기전 '+'연산 모두를 연산한 후
  # '-'연산으로 빼주면 된다.
  formula_second = deque()
  result = deque()

  while formula:
    tmp = formula.popleft()
    if tmp != '+':
      formula_second.append(tmp)
    else:
      formula_second.append(formula_second.pop() + formula.popleft())
  
  while formula_second:
    tmp = formula_second.popleft()
    if tmp != '-':
      result.append(tmp)
    else:
      result.append(result.pop() - formula_second.popleft())
  
  return result[0]



operator = ['-','+']

formula = deque()
inp = input()
n = ''
for word in inp:
  # 문자가 연산자인경우 덱에 이전의 정수와 연산자를 삽임함 
  if word in operator:
    formula.append(int(n))
    formula.append(word)
    n = ''
  else:
    n += word
# 마지막 정수를 삽입 
formula.append(int(n))

print(lost_bracket(formula))
