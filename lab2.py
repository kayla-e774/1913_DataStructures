# lab 2
# Kayla Engelstad


class Zillion(object):

    def __init__(self, digits=''):
        self.digits = digits
        
        nums = False
        numList = []

        # check for valid numbers throughout length of digits input
        for i in range(len(self.digits)):
            val = self.digits[i]
            if val in ('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'):
                nums = True
                numList.append(int(val))
            elif val not in ('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ',', ' '):
                raise RuntimeError

        if nums == False:
            raise RuntimeError

        self.digits = numList

    def isZero(self):
        ans = True

        for i in range(len(self.digits)):
            if self.digits[i] != 0:
                ans = False

        return ans

    def toString(self):
        string = ''

        for i in range(len(self.digits)):
            string += str(self.digits[i])

        return string

    def increment(self):
        
        if self.digits == []:
                return []
        
        elif self.digits[-1] < 9:
                self.digits[-1] += 1
                return self.digits
        
        elif self.digits[-1] == 9:

                i = len(self.digits) - 1

                while self.digits[i] == 9 and i >= 0:
                        self.digits[i] = 0
                        i -= 1
        
                if i < 0 :
                        self.digits = [1] + self.digits
                else:
                        self.digits[i] += 1
                        
                return self.digits

#
#  TESTS. Test the class Zillion for CSci 1913 Lab 2.
#
#    James Moen
#    30 Jan 17
#
#  Every test is followed by a comment which shows what must be printed if your
#  code works correctly. It also shows how many points the test is worth, for a
#  total of nn possible points.
#

try:
  z = Zillion('')
except RuntimeError:
  print('Empty string')

# It must print 'Empty string' without apostrophes. 2 points.

try:
  z = Zillion(' , ')
except RuntimeError:
  print('No digits in the string')

# It must print 'No digits in the string' without apostrophes. 2 points.

try:
  z = Zillion('1+0')
except RuntimeError:
  print('Non-digit in the string')

# It must print 'Non-digit in the string' without apostrophes. 2 points.

try:
  z = Zillion('0')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('000000000')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('000 000 000')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('997')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing.  2 points.

print(z.isZero())    #  It must print False. 2 points.

print(z.toString())  #  It must print 997. 2 points.

z.increment()

print(z.toString())  #  It must print 998. 2 points.

z.increment()

print(z.toString())  #  It must print 999. 2 points.

z.increment()

print(z.toString())  #  It must print 1000. 2 points.

try:
  z = Zillion('0 9,9 9')
except:
  print('This must not be printed')

#  It must print nothing.  3 points.

z.increment()
print(z.toString())  #  It must print 1000. 2 points.
