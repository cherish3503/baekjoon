import sys

count = [6,2,5,5,4,5,6,3,7,6]
min_first = [8,1,1,2,2,2,6]
min_mid = [8,0,0,0,0,0,0]
min_last = [8,0,1,7,4,2,0,8]
max_arr = [1,7]



# 가장 작은 수를 표현하려면 가장 작은 자릿수를 가지면 된다.
# 8이 성냥을 가장 많이 소비하므로 8을 많이 사용하자
# 첫번째 숫자가 작으면 가장 작음 -> 그리디
#
# 가장 큰 수를 표현하려면 가장 큰 자릿수를 가지면 된다.
# 1이 가장 적게 소비하므로 1을 많이 소비하자


def matchstickMin(n):
    # 2-> 1, 3->7 4->4 5->3 6->6, 7->8
    # 8->10, 9->18, 10->22, 11->20, 12->28, 13->68, 14->88
    #
    # 첫 입력 n으로 자릿수 특정: n//7
    # n%7로 해당 자리 입력

    if n==6:
        return 6

    ret = 0
    if (n-1)//7 >= 1:
        ret += min_first[n%7] * 10**((n-1)//7)
        n -= count[min_first[n%7]]
        while (n-1)//7 >= 1:
            ret += min_mid[n%7] * 10**((n-1)//7)
            n -= count[min_mid[n%7]]
    ret += min_last[n%7]
    return ret

def matchstickMax(n):
    # 2->1, 3->7, 4->11,5->71
    ret = 0
    while n//2 >= 1:
        ret += max_arr[n%2] * 10**(n//2 -1)
        n -= count[max_arr[n%2]]
    return ret



lineN = int(sys.stdin.readline())
for i in range(lineN):
    n = int(sys.stdin.readline())
    print(matchstickMin(n), matchstickMax(n))


