# Project 1
# Kayla Engelstad 

class Random(object):
    def __init__(self, seed=0):
        self.seed = seed

    def next(self, range):
        n = self.seed
        n2 = ((7 ** 5) * n) % ((2 ** 31) - 1)
        newN2 = n2 % range
        return newN2

    def choose(self, letters):
        val = self.next(len(letters))
        return letters[val]

class Mnemonic(object):
    def __init__(self, seed=0):
        self.random = Random(seed = seed)
        self.follow = {'a' : '', 'b' : '', 'c' : '', 'd' : '', 'e' : '', 'f' : '', 'g' : '', 'h' : '',\
                      'i' : '', 'j' : '', 'k' : '', 'l' : '', 'm' : '', 'n' : '', 'o' : '', 'p' : '',\
                      'q' : '', 'r' : '', 's' : '', 't' : '', 'u' : '', 'v' : '', 'w' : '', 'x' : '',\
                      'y' : '', 'z' : ''}
        self.letters = {'0' : 'z', '1' : 'q', '2' : 'abc', '3' : 'def', '4' : 'ghi', '5' : 'jkl',\
                       '6' : 'mno', '7' : 'prs', '8' : 'tuv', '9' : 'wxy'}
        
    def add(self, word):
        for i in range(len(word) - 1):
            val = word[i]
            self.follow[val] += word[i + 1]

        return self.follow

    def make(self, number):
        mnemonic = ""
        for i in range(len(number) - 1):
            if i == 0:
                firstVal = number[0]
                m = self.random.choose(self.letters[str(firstVal)])
                mnemonic += m
                
            else:
                m = mnemonic[i]

            secondVal = number[i + 1]
            possible = self.letters[secondVal]
            m2 = []
            plist = []

            for j in range(len(self.letters[secondVal])):
                for k in range(len(self.follow[m])):
                    if self.letters[secondVal][j] in self.follow[m][k]:
                        x = self.letters[str(secondVal)][j]
                        m2.append(x)

            for j in range(len(possible)):
                for k in range(len(m2)):
                    if possible[j] in m2[k]:
                        plist.append(possible[j])

            if plist == []:
                return ''

            nextLetter = self.random.choose(plist)
            mnemonic += str(nextLetter)

        return mnemonic



# main

# initialize Mnemonic object
m = Mnemonic(101)

# Dulche List
m.add('about')
m.add('after')
m.add('again')
m.add('always')
m.add('an')
m.add('and')
m.add('any')
m.add('apple')
m.add('around')
m.add('as')
m.add('ask')
m.add('away')
m.add('baby')
m.add('back')
m.add('ball')
m.add('bear')
m.add('because')
m.add('bed')
m.add('been')
m.add('before')
m.add('bell')
m.add('best')
m.add('better')
m.add('big')
m.add('bird')
m.add('birthday')
m.add('blue')
m.add('boat')
m.add('both')
m.add('box')
m.add('boy')
m.add('bread')
m.add('bring')
m.add('brother')
m.add('buy')
m.add('by')
m.add('cake')
m.add('call')
m.add('can')
m.add('car')
m.add('carry')
m.add('cat')
m.add('chair')
m.add('chicken')
m.add('children')
m.add('christmas')
m.add('claus')
m.add('clean')
m.add('coat')
m.add('cold')
m.add('come')
m.add('corn')
m.add('could')
m.add('cow')
m.add('cut')
m.add('day')
m.add('does')
m.add('dog')
m.add('doll')
m.add('done')
m.add('dont')
m.add('door')
m.add('down')
m.add('draw')
m.add('drink')
m.add('duck')
m.add('egg')
m.add('eight')
m.add('every')
m.add('eye')
m.add('fall')
m.add('far')
m.add('farm')
m.add('farmer')
m.add('fast')
m.add('father')
m.add('feet')
m.add('find')
m.add('fire')
m.add('first')
m.add('fish')
m.add('five')
m.add('floor')
m.add('flower')
m.add('fly')
m.add('for')
m.add('found')
m.add('from')
m.add('full')
m.add('funny')
m.add('game')
m.add('garden')
m.add('gave')
m.add('girl')
m.add('give')
m.add('giving')
m.add('go')
m.add('goes')
m.add('goodbye')
m.add('got')
m.add('grass')
m.add('green')
m.add('ground')
m.add('grow')
m.add('had')
m.add('hand')
m.add('has')
m.add('head')
m.add('help')
m.add('her')
m.add('here')
m.add('hill')
m.add('him')
m.add('his')
m.add('hold')
m.add('home')
m.add('horse')
m.add('hot')
m.add('house')
m.add('how')
m.add('hurt')
m.add('if')
m.add('in')
m.add('is')
m.add('it')
m.add('its')
m.add('jump')
m.add('just')
m.add('keep')
m.add('kind')
m.add('kitty')
m.add('know')
m.add('laugh')
m.add('leg')
m.add('let')
m.add('letter')
m.add('light')
m.add('little')
m.add('live')
m.add('long')
m.add('look')
m.add('made')
m.add('make')
m.add('man')
m.add('many')
m.add('may')
m.add('me')
m.add('men')
m.add('milk')
m.add('money')
m.add('morning')
m.add('mother')
m.add('much')
m.add('my')
m.add('myself')
m.add('name')
m.add('nest')
m.add('never')
m.add('night')
m.add('not')
m.add('of')
m.add('off')
m.add('old')
m.add('once')
m.add('one')
m.add('only')
m.add('open')
m.add('or')
m.add('over')
m.add('own')
m.add('paper')
m.add('party')
m.add('pick')
m.add('picture')
m.add('pig')
m.add('play')
m.add('pull')
m.add('put')
m.add('rabbit')
m.add('rain')
m.add('read')
m.add('red')
m.add('right')
m.add('ring')
m.add('robin')
m.add('round')
m.add('run')
m.add('said')
m.add('santa')
m.add('school')
m.add('see')
m.add('seed')
m.add('seven')
m.add('shall')
m.add('sheep')
m.add('shoe')
m.add('show')
m.add('sing')
m.add('sister')
m.add('sit')
m.add('six')
m.add('sleep')
m.add('small')
m.add('snow')
m.add('some')
m.add('song')
m.add('squirrel')
m.add('start')
m.add('stick')
m.add('stop')
m.add('street')
m.add('sun')
m.add('table')
m.add('take')
m.add('tell')
m.add('ten')
m.add('thank')
m.add('the')
m.add('their')
m.add('them')
m.add('then')
m.add('these')
m.add('thing')
m.add('think')
m.add('those')
m.add('three')
m.add('time')
m.add('to')
m.add('today')
m.add('together')
m.add('top')
m.add('toy')
m.add('tree')
m.add('try')
m.add('two')
m.add('up')
m.add('upon')
m.add('us')
m.add('use')
m.add('very')
m.add('walk')
m.add('warm')
m.add('wash')
m.add('watch')
m.add('water')
m.add('way')
m.add('we')
m.add('were')
m.add('when')
m.add('where')
m.add('which')
m.add('why')
m.add('wind')
m.add('window')
m.add('wish')
m.add('wood')
m.add('work')
m.add('would')
m.add('write')
m.add('yellow')
m.add('you')
m.add('your')

#Tests and Results (results are commented)
print("Tests:\n")
print('"' + m.make('6862377') + '"' + " from 6862377")  #  "ouncers"
print('"' + m.make('6573379') + '"' + " from 6573379")  #  "olpedry"
print('"' + m.make('6273466') + '"' + " from 6273466")  #  "obreino"
print('"' + m.make('5426396') + '"' + " from 5426396")  #  "licoeyo"
print('"' + m.make('4736974') + '"' + " from 4736974")  #  "irenysi"
print('"' + m.make('3694788') + '"' + " from 3694788")  #  "fowhrtt"
print('"' + m.make('7187425') + '"' + " from 7187425")  #  "squsick"
print("\nShorter:")
print('"' + m.make('6734') + '"' + " from 6734")  #  "orei"


