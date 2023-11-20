package Projects;

import java.util.Scanner;

class WordSearch
{
    public static void main(String[] args)
    {
        WordSearch();
    }

    public static void Front(String Word, String[] Puzzle, int i, int j)
    {
        boolean found = true;
        while(!found)
        {
            for(int k = 0; k < Word.length(); k++)
            {
                if(Word.charAt(k) != Puzzle[i].charAt(j + k))
                {
                    return false;
                
                }
            }
        }
    }

    public static void WordSearch()
    {
        final String WORD = "ALEN";

        final String[] Puzzle = {"N K R E C S N I R U T J E A L U S R U",
                        "A A E F R E C A C N I U E W V N H O J",
                        "M R O M A K B R I T M O R N H F B Y V",
                        "H E A D A L O V E L A C E I M R R S P",
                        "C N N I W I R T H O O O P K R A I E H",
                        "L S I J P W E N D Y H A L L E N N R I",
                        "E P T K K K N V O K S I L A Y I F G L",
                        "W A A S C H M A U R I S E U A V Z E I",
                        "N R G T A W E E L T R U M S M R S Y P",
                        "O C G R O B G E F A J E A N N E T T E",
                        "D K Y A A N W X G A R D R L A D I M M",
                        "O O T W O O E S O H J G I O S A Z H A",
                        "G N O N T P I H E D S E N P I C I A G",
                        "R E R E H R Y E O B A R B A R A R M W",
                        "A S O U H N C I J P D C G K A L A M A",
                        "C B D C O I U H E L P M N Y M M W E L",
                        "E O S T R A C H E Y D E I C R N H D I",
                        "L R P U D E N N I N G E R O O E K B P",
                        "E N A W S R E N R E B M U F F Y L R Q",
                        "E M V O N N E U M A N N T D A N A U A"};

        for(int i = 0; i < Puzzle.length;i++)
        {
            for(int j = 0; j < Puzzle[0].length();j = j + 2)
            {
                if(Puzzle[i].charAt(j) == WORD.charAt(0))
                {
                    
                }
            }
        }
    }
}
