# Kayla Engelstad
# 1913 - lab 1
# Tuple Algebraic Calculator

# First four functions return necessary operators and operands w/in tuple
def left(t):
    return t[0]

def op(t):
    return t[1]

def right(t):
    return t[2]

# check for variable in tuple
def isInside(var, t):
    # if the variable is the only option, return true
    if var == t:
        return True

    # if the argument is a tuple, check the components of the tuple by side
    elif 'tuple' in str(type(t)):
        if isInside(var, left(t)) or isInside(var, right(t)):
            return True
        else:
            return False

    # Otherwise, the variable is not in the tuple
    else:
        return False

# solve for each operand depending on the position of the variable.
def solvingAdd(var, eq):
    lt = left(eq)
    rt = right(eq)

    if isInside(var, left(lt)):
        neweq = (left(lt), '=', (rt, '-', right(lt)))

    else:
        neweq = (right(lt), '=', (rt, '-', left(lt)))

    return neweq

def solvingSubtract(var, eq):
    lt = left(eq)
    rt = right(eq)

    if isInside(var, left(lt)):
        neweq = (left(lt), '=', (rt, '+', right(lt)))

    else:
        neweq = (right(lt), '=', (left(lt), '-', rt))

    return neweq

def solvingMultiply(var, eq):
    lt = left(eq)
    rt = right(eq)

    if isInside(var, left(lt)):
        neweq = (left(lt), '=', (rt, '/', right(lt)))

    else:
        neweq = (right(lt), '=', (rt, '/', left(lt)))
        
    return neweq

def solvingDivide(var, eq):
    lt = left(eq)
    rt = right(eq)

    if isInside(var, left(lt)):
        neweq = (left(lt), '=', (rt, '*', right(lt)))

    else:
        neweq = (right(lt), '=', (left(lt), '/', rt))
        
    return neweq

# reads left side of tuple, directs the operands to the right function based on operator.
def solving(var, eq):
    LeftSide = left(eq)

    # stops if there is only one operand in the equation.
    if var == LeftSide:
        return eq

    else:
        if op(LeftSide) == '+':
            new = solvingAdd(var, eq)
            return solving(var, new)
        
        elif op(LeftSide) == '-':
            new = solvingSubtract(var, eq)
            return solving(var, new)
        
        elif op(LeftSide) == '*':
            new = solvingMultiply(var, eq)
            return solving(var, new)
        
        elif op(LeftSide) == '/':
            new = solvingDivide(var, eq)
            return solving(var, new)

# Checks if the variabple exists, within the left side of the tuple. Otherwise flip sides, and check again.
# Once the variabple is at the left side, solve the thing.
def solve(var, eq):
    if isInside(var, left(eq)):
        return solving(var, eq)

    else:
        neweq = (right(eq), '=', left(eq))
        return solving(var, neweq)



#Lab 1 test
#
#  TESTS. Test the equation solver for CSci 1913 Lab 1.
#
#    James Moen
#    22 Jan 17
#
#  Every test is followed by a comment which shows what must be printed if your
#  code works correctly. It also shows how many points the test is worth, for a
#  total of 35 possible points.
#

print(isInside('x', 'x'))                          #  True   1 point
print(isInside('x', 'y'))                          #  False  1 point
print(isInside('x', ('x', '+', 'y')))              #  True   2 points
print(isInside('x', ('a', '+', 'b')))              #  False  2 points
print(isInside('+', ('a', '+', 'b')))              #  False  2 points
print(isInside('x', (('m', '*', 'x'), '+', 'b')))  #  True   2 points

print(solve('x', (('a', '+', 'x'), '=', 'c')))
#  ('x', '=', ('c', '-', 'a'))  2 points

print(solve('x', (('x', '+', 'b'), '=', 'c')))
#  ('x', '=', ('c', '-', 'b'))  2 points

print(solve('x', (('a', '-', 'x'), '=', 'c')))
#  ('x', '=', ('a', '-', 'c'))  2 points

print(solve('x', (('x', '-', 'b'), '=', 'c')))
#  ('x', '=', ('c', '+', 'b'))  2 points

print(solve('x', (('a', '*', 'x'), '=', 'c')))
#  ('x', '=', ('c', '/', 'a'))  2 points

print(solve('x', (('x', '*', 'b'), '=', 'c')))
#  ('x', '=', ('c', '/', 'b'))  2 points

print(solve('x', (('a', '/', 'x'), '=', 'c')))
#  ('x', '=', ('a', '/', 'c'))  2 points

print(solve('x', (('x', '/', 'b'), '=', 'c')))
#  ('x', '=', ('c', '*', 'b'))  2 points

print(solve('y', ('y', '=', (('m', '*', 'x'), '+', 'b'))))
# ('y', '=', (('m', '*', 'x'), '+', 'b'))  2 points

print(solve('x', ('y', '=', (('m', '*', 'x'), '+', 'b'))))
# ('x', '=', (('y', '-', 'b'), '/', 'm'))  2 points

print(solve('a', (('b', '+', 'c'), '=', ('d', '*', (('a', '/', 'e'), '-', 'f')))))
# ('a', '=', (((('b', '+', 'c'), '/', 'd'), '+', 'f'), '*', 'e'))  5 points
