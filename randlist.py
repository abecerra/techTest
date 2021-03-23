from random import randint 

def random(n):
    result = list(range(1,n+1))
    for j in range(n):
        # random position in list
        r = randint(0,n-1)
        # swap values:
        result[j], result[r] = result[r], result[j]
    return result

print(random(10))
