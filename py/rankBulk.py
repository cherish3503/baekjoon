#Baekjoon_7568

def rankBulk(group):
    for i in group:
        i['rank'] = 1
        for j in group:
            if i['weight'] < j['weight'] and i['height'] < j['height']:
                i['rank'] += 1
    
    return group

group = []
for i in range(int(input())):
    w,h = map(int, input().split())
    group.append({'weight' : w, 'height' : h})

group = rankBulk(group)

for i in group:
    print(i['rank'], end = ' ')
print()
