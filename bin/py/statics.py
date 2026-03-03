#Baekjoon_2108

import sys

class Statics:
    def __init__(self, arr):
        self.arr = sorted(arr)
    
    def arithmetic_mean(self):
        return round(sum(self.arr)/len(self.arr))
    
    def median(self):
        return(self.arr[len(self.arr)//2])

    def mode(self):
        max_n = list()
        max = 1
        count = 0
        tmp = self.arr[0]
        for i in self.arr:
            if i == tmp:
                count += 1
            else:
                tmp = i
                count = 1
        
            if count == max:
                max_n.append(i)
            elif count > max:
                max_n.clear()
                max_n.append(i)
                max = count
        
        if len(max_n) > 1:
            return max_n[1]
        else:
            return max_n[0]
    
    def range(self):
        return self.arr[-1] - self.arr[0]
    
    
arr = list()
for i in range(int(sys.stdin.readline())):
    arr.append(int(sys.stdin.readline()))

stat = Statics(arr)

print(stat.arithmetic_mean())
print(stat.median())
print(stat.mode())
print(stat.range())
