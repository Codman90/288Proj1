package edu.iastate.cs228.hw1;

/** @author Cody Fredericks*/

public class ProteinSequence extends Sequence
{
  /** constructs a protein sequence 
   * @param psarr char array*/
  public ProteinSequence(char[] psarr)
  {
    super(psarr);
    for (int i = 0; i < psarr.length; i++)
    if (isValidLetter(psarr[i]) == false)
    throw new IllegalArgumentException
    ("Invalid sequence letter for " + this.getClass());	
  }
  
  /** checks letter
   * @param aa char
   * @return true or false boolean*/
  @Override
  public boolean isValidLetter(char aa)
  {
	  if (aa == 'B' || aa == 'b' 
	   || aa == 'J' || aa == 'j'
	   || aa == 'O' || aa == 'o'
	   || aa == 'U' || aa == 'u'
	   || aa == 'X' || aa == 'x'
	   || aa == 'Z' || aa == 'z')
	  return false;
	  else return true;
  }
}