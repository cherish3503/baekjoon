#Baekjoon_10816

import sys

def numberCardDict(card):
    cardD = dict()
    card.sort()
    count = 0
    tmp = card[0]
    
    for i in card:
        if i == tmp:
            count += 1
        else:
            tmp = i
            count = 1
        
        cardD[i] = count
    
    return cardD

sys.stdin.readline()
cardD = numberCardDict(list(map(int, sys.stdin.readline().split())))
sys.stdin.readline()

arr = list(map(int, sys.stdin.readline().split()))
for i in arr:
    if i in cardD:
        print(cardD[i], end = ' ')
    else:
        print(0, end = ' ')
