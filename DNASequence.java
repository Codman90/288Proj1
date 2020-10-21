package edu.iastate.cs228.hw1;

/** @author Cody Fredericks*/

public class DNASequence extends Sequence
{
	
  /** constructs an dnasequence 
   * @param dnaarr char array */
  public DNASequence(char[] dnaarr)
  {
	  super(dnaarr);
	  
	  for (int i = 0; i < dnaarr.length; i++)
	  {
		 if (isValidLetter(dnaarr[i]) == false)  
		 throw new IllegalArgumentException
		 ("Invalid sequence for " + this.getClass());	 
	  }

	  super.seqarr = new char[dnaarr.length];
	  for (int i = 0; i < dnaarr.length; i++) super.seqarr[i] = dnaarr[i];;
	  
  }
  
  /** checks a given letter 
   * @param let char
   * @return true or false boolean*/
  @Override
  public boolean isValidLetter(char let)
  {

   switch (let)
   {
   case 'a': return true;
   
   case 'A': return true;
   
   case 'c': return true;
   
   case 'C': return true;
   
   case 'g': return true;
   
   case 'G': return true;
   
   case 't': return true;
   
   case 'T': return true;
   }
	        return false;
  }

  /** creates a temp array that is its reveres complement
   * @return temp char array*/
  public char[] getReverseCompSeq()
  {
	char[] temp = new char[super.seqarr.length]; 
	
	int j = 0;
	for (int i = temp.length - 1; i >= 0; i--)
    {
		temp[j] = super.seqarr[i];
		j++;
	}
	
	for (int i = 0; i < temp.length; i++)
	{
		switch (temp[i])
		{
		case 'a': temp[i] = 't'; break;
		
		case 'A': temp[i] = 'T'; break;
		
		case 't': temp[i] = 'a'; break;
		
		case 'T': temp[i] = 'A'; break;
		
		case 'c': temp[i] = 'g'; break;
		
		case 'C': temp[i] = 'G'; break;

		case 'g': temp[i] = 'c'; break;
		
		case 'G': temp[i] = 'C'; break;
		}	
	}

	return temp;
  }
  /**is used to help get the reverse complement*/
  public void reverseComplement()
  {
	  char[] temp = new char[super.seqarr.length]; 
	  
	  for (int i = 0; i < temp.length; i++) 
	  temp[i] = getReverseCompSeq()[i];
	  
	  temp = getReverseCompSeq();
	  
	  for (int i = 0; i < temp.length; i++) 
	  super.seqarr[i] = temp[i];
  }
}

