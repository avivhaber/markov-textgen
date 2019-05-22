# markov-textgen
Generates text from a source file using a markov chain model.

To run, enter `javac Markov.java` then `java Markov file order n m`.

`file` is the file name of the source text. This file must be in the same folder as the code, and each sentence should be line separated. A text file of all of Trump's tweets has been included for playing around.

`order` is the chain's order (how many characters are considered a unique state). If it's too low, you'll get gibberish. If it's too high, you'll get exact copies of the source material.

`n` is the number of sentences you wish to generate. 

`m` is the maximum character length of each sentence.

For example, you can enter `java Markov trump.txt 9 1 280` and you may get: "I really have a clue! @FoxNews . Much, much bigger than a few of the year. @TrumpTowerNY (a NY icon) offers $5 million birds a year http://tmblr.co/ZnDBauhcIlub"
