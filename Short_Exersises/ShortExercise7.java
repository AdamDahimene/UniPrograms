import java.util.Scanner; // Needed to make Scanner available

class Candidate
{
    String name;
    String party;
    int votes;
    boolean won = false;
}

class ElectionResults
{
    public static void main (String [] a)
    {
        Election();
        
        return;
    }

    //Outputs a message and asks user for a responce
    public static String InputString(String message)
    {
        String answer;
        Scanner scanner = new Scanner(System.in);

        System.out.println(message);
        answer = scanner.nextLine();

        return answer;
    }

    //Compares the two amount of votes and returns the candidate with the biggest
    public static Candidate compare(Candidate candidate, Candidate candidate2)
    {
        if (candidate.votes > candidate2.votes)
        {
            candidate.won = true;
            return candidate;
        }
        else if (candidate.votes < candidate2.votes)
        {
            candidate2.won = true;
            return candidate2;
        }
        else
        {
            return candidate;
        }
    }

    //Sets the values in a record for a candidate
    public static Candidate setCandidate(Candidate candidate, String name, String party, int votes)
    {
        candidate.name = name;
        candidate.party = party;
        candidate.votes = votes;

        return candidate;
    }

    //makes a String into an integer and if error asks again for an input
    public static int Valid(String votes)
    {
        int time;
        boolean again = true;

        while(again)
        {
            for(int i = 0; i < votes.length(); i++)
            {
                if(votes.charAt(i) < '0' || votes.charAt(i) > '9')
                {
                    votes = InputString("Enter an integer");
                    break;
                }
                else if(i == votes.length() - 1)
                {
                    again = false;
                }
            }
        }

        time = Integer.parseInt(votes);
        return time;
    }

    //main part where asks for inputs and returns results
    public static void Election()
    {
        String name;
        String party;
        int votes;

        //create the records
        Candidate candidate = new Candidate();
        Candidate candidate2 = new Candidate();
        Candidate winner = new Candidate();

        name = InputString("What is the name of the first candidate?");
        party = InputString("What party did they stand for?");
        votes = Valid(InputString("How many votes did they gain"));

        candidate = setCandidate(candidate, name, party, votes);

        name = InputString("What is the name of the second candidate?");
        party = InputString("What party did they stand for?");
        votes = Valid(InputString("How many votes did they gain"));

        candidate2 = setCandidate(candidate2, name, party, votes);

        winner = compare(candidate, candidate2);

        //prints the winner
        if (winner.won)
        {
            System.out.println(winner.name + " of "+winner.party + " is declared the winner with " + winner.votes + " votes.");
            System.out.println("They have a majority of " + winner.votes);
        }
        else
        {
            System.out.println("There will be a new election.");
        }
    }
}