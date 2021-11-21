


def countCroatiaAl(ipStr):
    count = 0
    for i in range(len(ipStr)):
        count += 1

        if len(ipStr) - i > 1:
            if ipStr[i] == 'c':
                if ipStr[i+1] == '=':
                    count-=1
                elif ipStr[i+1] == '-':
                    count-=1
                    
            elif ipStr[i] == 'd':
                if ipStr[i+1] == 'z':
                    if (len(ipStr) - i > 2) and (ipStr[i+2] == '=') :
                        count-=1 #z=

                elif ipStr[i+1] == '-':
                    count-=1

            elif ipStr[i] == 'l':
                if ipStr[i+1] == 'j':
                    count-=1

            elif ipStr[i] == 'n':
                if ipStr[i+1] == 'j':
                    count-=1

            elif ipStr[i] == 's':
                if ipStr[i+1] == '=':
                    count-=1

            elif ipStr[i] == 'z':
                if ipStr[i+1] == '=':
                    count-=1
                
                
        
    
    return count
    
    
ipStr = input()
print(countCroatiaAl(ipStr))

