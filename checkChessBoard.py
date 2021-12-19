#Baekjoon_1018
# B : 0
# W : 1
#BoardSize : 8x8
BOARD_ROW = 8
BOARD_COL = 8


# def printL(arr):
#     for line in arr:
#         print(line)
        

def checkChessBoard(matrix):
    row = len(matrix)
    col = len(matrix[0])
    
    minTmp = -1
    
    
    for i in range(row - BOARD_ROW + 1):
        for j in range(col - BOARD_COL + 1):
            matrix_tmp = matrix[i:i+BOARD_ROW]

            matrix_chess = list()
            for l in range(len(matrix_tmp)):
                matrix_chess.append((matrix_tmp[l])[j:j+BOARD_COL])
                
            if minTmp == -1 or leastChess(matrix_chess) < minTmp:
                minTmp = leastChess(matrix_chess)
    
    return minTmp
    
def leastChess(matrix):


    countB = 0
    countW = 0
    
    #init : B
    for i in range(BOARD_ROW):
        for j in range(BOARD_COL):
            if matrix[i][j] != (i+j)%2:
                countB += 1
                
    #init : W
    for i in range(BOARD_ROW):
        for j in range(BOARD_COL):
            if matrix[i][j] != (i+j+1)%2:
                countW += 1
    
    return countB if countB < countW else countW


matrix = list()
row , col = map(int, input().split())

for r in range(row):
    rList = list()
    inpS = input()
    for c in range(col):
        if inpS[c] == 'B':
            rList.append(0)
        elif inpS[c] == 'W':
            rList.append(1)
    matrix.append(rList)
    
print(checkChessBoard(matrix))

