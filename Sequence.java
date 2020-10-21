package edu.iastate.cs228.hw1;

/** @author Cody Fredericks*/

public class Sequence
{
  // made public instead of protected for grading.
  /**array that holds the sequence */
  public char[] seqarr; 
 
  /**Constructs a sequence from a given array
   * @param sarr char array */
  public Sequence(char[] sarr)
  {
	  seqarr = new char[sarr.length];
	  
    for (int i = 0; i < sarr.length; i++)
    {
    	if (isValidLetter(sarr[i]) == false) 
    	throw new IllegalArgumentException
    	("Invalid sequence for " + this.getClass());	
    	
    	seqarr[i] = sarr[i];
    }
  }
  /** @return seqarr.length int*/
  public int seqLength()
  {
    return seqarr.length;
  }
  
  /** the method makes and returns 
   * a copy of the char array seqarr
  @return seqarrCopy char array*/
  public char[] getSeq()
  { 
	char[] seqarrCopy = new char[seqLength()]; 
	for (int i = 0; i < seqLength(); i++) seqarrCopy[i] = seqarr[i];
    return seqarrCopy;
  }
  
  /** @return s string*/
  public String toString()
  {
    String s = "";
	for (int i = 0; i < seqLength(); i++)  
	{
		s = s + seqarr[i];
	}
    return s;
  }

  /** @param obj object
   * @return true or false boolean*/
  public boolean equals(Object obj)
  { 
	 
  for (int i = 0; i < seqLength(); i++)
  {
	  if (obj != null 
	  && Character.toUpperCase(((Sequence) obj).getSeq()[i]) 
	  != Character.toUpperCase((this.getSeq()[i]))) return false; 
  }
    return true;
  }

  /**@param let char 
   * @return true or false boolen*/
  public boolean isValidLetter(char let)
  {
    if (Character.isLowerCase(let) == true
     || Character.isUpperCase(let) == true) 
    return true;	
    else return false;
  }

}
