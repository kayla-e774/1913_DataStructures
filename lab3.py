# Lab 3
# Kayla Engelstad

def new(function, lst):
    if lst == []:
        return []

    else:
        return [function(lst[0])] + new(function, lst[1:])

def most(function, lst):

    if new(function, lst).count(True) > (len(lst) / 2):
        return True

    else:
        return False

def sigma(function, Num1, nextNum):

    if Num1 > nextNum:
        return 0

    else:
        if Num1 == nextNum:
            return function(Num1)
        else:
            return function(Num1) + sigma(function, Num1 + 1, nextNum)
