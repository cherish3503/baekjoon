#Baekjoon_1316

def groupWordCheck(str):
    word = list()
    
    prWord = str[0]
    for i in str:
        if i != prWord:
            word.append(prWord)
            if i in word:
                return False
        prWord = i
    
    return True

    
    

ipNum = int(input())
count = 0
for i in range(ipNum):
    if groupWordCheck(input()):
        count += 1
        
print(count)
