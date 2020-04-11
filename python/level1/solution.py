from math import sqrt

def solve(area):
  res = []

  while area > 0:
    currentSquare = int(sqrt(area)) ** 2
    res.append(currentSquare)
    area -= currentSquare

  return res
