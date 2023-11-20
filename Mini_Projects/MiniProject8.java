import java.util.Scanner;
import java.io.*;
import java.util.Random;

class Animal
{
    String animal;
    String injury;
    int damage;
}

class Forest_Game8
{

    public static void main (String [] a) throws IOException
    {
        final int Health_Points = 20; //Constant variable as it does not change in main
        String name;
        int score;

        String file = AskFile();

        name = Beginning(); //Gets name of user

        score = Middle(Health_Points, name, file); //Main part

        End(score); //Prints score

        return;
    }
    

    //Gets message and prints message then asks user input and returns it
    public static String InputString(String message)
    {
        String answer;

        Scanner scanner = new Scanner(System.in);

        System.out.print(message + "  ");
        answer = scanner.nextLine();

        //check if input is empty
        while(answer.isEmpty())
        {
            System.out.print("Cannot leave empty  ");
            answer = scanner.nextLine();
        }

        return answer;
    }

    //Checks if input is integer
    public static int InputNum(String message)
    {
        String input = InputString(message);

        boolean again = true;

        while(again)
        {
            for(int i = 0; i < input.length(); i++)
            {

                if(input.charAt(i) == '-') //check if negative number
                {
                    input = InputString("Enter a positive integer from 0 to 10");
                    break;
                }
                else if(input.charAt(i) < '0' || input.charAt(i) > '9') //checks if a number is not inputed
                {
                    input = InputString("Enter an integer form 0 to 10");
                    break;
                }
                else if(input.length() > 1 & i == 0 & input.charAt(i) != '1') //checks if input is 0 to 10
                {
                    input = InputString("Enter an integer form 0 to 10");
                    break;
                }
                else if(input.length() > 1 & i == 1 & input.charAt(i) != '0') //check if input is 0 to 10
                {
                    input = InputString("Enter an integer form 0 to 10");
                    break;
                }
                else if(i == input.length() - 1)
                {
                    again = false;
                }
            }
        }

        int num = Integer.parseInt(input);
        return num;
    }


    //Start of code and prints what the program does and asks for the name of adventurer
    public static String Beginning()
    {
        String name;

        System.out.println("Hello adventurer! Welcome to The Forest.");
        System.out.println("You will be able to wander through a forest where you can heal sick animals and collect plants that improve your healing skills.");
        System.out.println("But be careful! Healing sick animals will lose you two health points.");
        System.out.println();

        name = InputString("What is your adventurer name going to be?  ");

        System.out.println(name + ", you are now in The Forest. You start with 20 health points.");
        System.out.println();

        return name;
        
    }


    //Prints the message of animal
    public static void Hurt_Animal(Animal animals, String name)
    {
        System.out.println(name + " just found a " + animals.animal + " with " + animals.injury + " with " + animals.damage + " damage points."); //prints what animal and how damaged

        return;
    }


    //Asks user if it should heal the animal
    public static Boolean Decision(String message)
    {
        String decision;
        decision = InputString(message);


        while (!decision.equalsIgnoreCase("Yes") & !decision.equalsIgnoreCase("No")) //checks if input is yes or no and if not then asks again until right input
        {
            decision = InputString("Please choose either Yes or No.");
        }
        
        if(decision.equalsIgnoreCase("Yes"))
        {
            return true;
        }
        return false;
    }


    //If healing then rolls a dice and sees if successful
    public static int Heal(Animal animal, int Health_Points)
    {
        Random rand = new Random();
        
        final int roll = rand.nextInt(11); //number from 0 to 10
        
        System.out.println();
        System.out.println("You have rolled... " + roll);
        System.out.println();
        
        
        if (roll >= getDamage(animal))
        {
            Health_Points = Health_Points + 2; //add two points
            System.out.println("Well Done! You have successfully healed the " + getName(animal) + ".");
            System.out.println("You now have " + Health_Points + " health points.");
            System.out.println();

            return Health_Points;
        }
        else
        {
            Health_Points = Unsuccessful(animal, Health_Points);

            return Health_Points;
        }
        
    }


    //if no heal then lose 1 point
    public static int NoHeal(Animal animal, int Health_Points)
    {
        Health_Points = Health_Points - 1;

        System.out.println();
        System.out.println("Poor " + getName(animal) + ", karma just hit you. You hit your head on a rock.");
        System.out.println("You lost 1 health point.");
        System.out.println("You now have " + Health_Points + " health points.");
        System.out.println();

        return Health_Points;
    }


    //asks if heal the animal again
    public static int Unsuccessful(Animal animal, int Health_Points)
    {

        Health_Points = Health_Points - 3; //lose three points

        System.out.println("Noooo! You were unsuccessful. Three points have been deducted.");
        System.out.println("You now have " + Health_Points + " health points.");
        System.out.println();

        if (Decision("Would you like to heal the " + animal + "?  ")) //asks if should heal again
        {
            Health_Points = Heal(animal, Health_Points); //tries again to heal
        }
        
        System.out.println();
        return Health_Points;
    }

    //set all values of animals in record
    public static Animal setAnimal(Animal Animal, String animal, String injury, int damage)
    {
        Animal.animal = animal;
        Animal.injury = injury;
        Animal.damage = damage;

        return Animal;
    }

    public static String getName(Animal animal)
    {
        return animal.animal;
    }

    public static String getInjury(Animal animal)
    {
        return animal.injury;
    }

    public static int getDamage(Animal animal)
    {
        return animal.damage;
    }

    //reads file and makes the records
    public static Animal[] CreateAnimals(String filename) throws IOException
    {
        final int AMOUNT = 6;

        BufferedReader inputStream = new BufferedReader (new FileReader(filename + ".csv"));

        final String [] animals = new String[AMOUNT];
        final String [] injurys = new String[AMOUNT];
        final int [] damages = new int[AMOUNT];

        //stores all values of csv file into the arrays
        for(int i = 0; i < AMOUNT;i++)
        {
            String read = inputStream.readLine();
            String[] components = read.split(",") ;

            animals[i] = components[0];
            injurys[i] = components[1];
            damages[i] = Integer.parseInt(components[2]);
        }

        inputStream.close();

        //create different animal records
        Animal Wolf = new Animal();
        Animal Rabbit = new Animal();
        Animal Deer = new Animal();
        Animal Racoon = new Animal();
        Animal Bear = new Animal();
        Animal Monkey = new Animal();

        //array of records
        Animal [] animal = {Wolf, Rabbit, Deer, Racoon, Bear, Monkey};
        

        for(int i = 0; i < 6; i++)
        {
            //set each record
            animal[i]  =setAnimal(animal[i], animals[i], injurys[i], damages[i]);
        }

        return animal;
    }

    //Ask if want to make own animals
    public static String AskFile() throws IOException
    {
        String filename;

        if(Decision("Would you like to create your own animals. If so you need to make 6 animals?"))
        {
            filename = valid(InputString("What would you like your file name to be"));
            PrintWriter csv_Writer = new PrintWriter (new FileWriter(filename + ".cvs")); // opens file

            for(int i = 0; i < 6;   i++)
            {
                String name = InputString((i + 1) + ") What is the name of the animal");
                String injury = InputString((i + 1) + ") What is the injury of the animal");
                int damage = InputNum((i + 1) + ") What is the damage of the animal");
                System.out.println();

                csv_Writer.println(name + "," + injury + "," + damage); //puts as a .csv file
            }
            csv_Writer.close();
        }
        else if(Decision("Would you like to import an already existing file"))
        {
            filename = valid(InputString("What is the name of the file"));
        }
        else{
            filename = "Original";
        }

        return filename;
    }

    //If the user writes .csv it gets removed
    public static String valid(String file)
    {
        file = file.split("\\.")[0];

        return file;
    }

    //Main part of program
    public static int Middle(int Health_Points, String name, String filename) throws IOException
    {
        int score = 0; // start of score

        Animal[] animals = CreateAnimals(filename);
        
        while (Health_Points > 0) //stops if health is 0
        {
            for (int i = 0; i < 6; i++) //goes through different animals
            {
                Hurt_Animal(animals[i], name);

                if (Decision("Would you like to heal the " + getName(animals[i]) + "?"))
                {
                    Health_Points = Heal(animals[i], Health_Points);
                    score++; //if choose heal then add one point to score

                }
                else
                {
                    Health_Points = NoHeal(animals[i], Health_Points);
                }
                if (Health_Points <= 0) //if reaches 0 then break for and while loop
                {
                    break;
                }
            }
        }
        return score;
    }

    //prints the score of the player
    public static void End(int score)
    {
        System.out.println();
        System.out.println("Game over :(");
        System.out.println("You have unfortunatly lost all health points.");
        System.out.println();
        System.out.println("Your score is " + score + ".");

        return;
    }
}