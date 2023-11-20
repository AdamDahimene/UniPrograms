package RandomProjects;

class TestRuns 
{
    // Convert the contents of an array to a String
    //
    public static String arrayToString (int[] array) 
    {
       String txt = "";
       
       for (int i=0; i < array.length-1; i++) 
       {
         txt = txt+array[i]+" ";
	   }
	   
	   if (array.length > 0)
	   { 
	       txt = txt+array[array.length - 1];
	   }

	   return txt;
    } // END printArray


    // Print a message
    //
    public static void report (String txt) 
    {
       System.out.println(txt);
       
       return;
    } // END report


    // quicksort: algorithm based on Gosling's variant from nist
    //
    public static void quicksort (int[] array, int from, int upto) 
    {
        // print details of call
        report("calling qs (" + arrayToString(array)+", "+from+", "+upto+")");

        if (from < upto)
        {


          // make the pivot value middle of array
          int pivot = array[(from+upto)/2];

          // set up two pointers into the array
          int lower = from, upper = upto;
        
          while (lower <= upper) 
          {
            // first move lower up over small elements
	 	    while ((array[lower] < pivot) && (lower < upto)) { lower++; }
	 	  
            // otherwise move upper down over large elements
		    while ((array[upper] > pivot) && (upper > from)) { upper--; }
		
            // if pointers haven't crossed
            if (lower <= upper) 
            {
		      int tmp = array[upper];
		      array[upper] = array[lower];
		      array[lower] = tmp;
		      lower++;
		      upper--;
		    }
	      }

          report("doing qs(..,., "+from+", "+upto+") with current "+  arrayToString(array));

	     if (from < upper) quicksort(array,from,upper);
	     if (lower < upto) quicksort(array,lower,upto);

	    }
	    report("leaving qs (..., "+from+", "+upto+") with result "+  arrayToString(array));
	    
        return;
     } // END quicksort



    public static void main (String[] param) 
    {

      int array[] = {10,7,8,6,1,4,3,2,5,9};

      report(arrayToString(array));
	  quicksort(array,0,9);
	  report("Result is: " + arrayToString(array));
	  
	  return;

    } // END main
} // END class quicksort