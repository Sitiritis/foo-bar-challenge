def solution(s):
  numLeftEmployees = 0
  result = 0

  for c in s:
    if c == '>':
      numLeftEmployees += 1
    elif c == '<':
      result += numLeftEmployees * 2

  return result
