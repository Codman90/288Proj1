package edu.iastate.cs228.hw1;

/** @author Cody Fredericks*/

public class GenomicDNASequence extends DNASequence
{
  // made public instead of private for grading.
 /**boolean array*/
  public boolean[] iscoding; 

  /** constructs a gDNASequence
   * @param gdnaarr char array*/
  public GenomicDNASequence(char[] gdnaarr)
  {
    super(gdnaarr);
    for (int i = 0; i < gdnaarr.length; i++)
    {
    	
	if (super.isValidLetter(gdnaarr[i]) == false)  
		throw new IllegalArgumentException
		("Invalid sequence for " + this.getClass());
    }
	  
    boolean[] b = new boolean[gdnaarr.length];
    for (int i = 0; i < b.length; i++) b[i] = false;
    iscoding = b;
	  
  }

  /** fills the iscoding array with
   *  true at the specified places
   *  @param first int
   *  @param last int*/
  public void markCoding(int first, int last)
  {
	int slen = seqLength();
    if (first < 0 
      || last < 0
      || first >= slen 
      || last >= slen)  
    	throw new IllegalArgumentException
    	("Coding border is out of bound");

    	if (first > last)
    	{
    		reverseComplement(); 
    		first = slen - 1 - first;
    		last = slen - 1 - last;
    	}
    	else
    	{
    		
    	}
    	
    	for (int i = first; i <= last - first + 1; i++)
    	iscoding[i] = true;
  }

  /**creates and fills a new array with exons
   * @param exonpos int array
   * @return exonarr char array with exons*/
  public char[] extractExons(int[] exonpos)
  {
    
	  int e = exonpos.length;
	  if (e == 0 || e % 2 != 0)
	  throw new IllegalArgumentException
	  ("Empty array or odd number of array elements");
	  
	  for (int i = 0; i < e - 1; i++)
	  {
		  
	  if (exonpos[i] < 0 || exonpos[i] >= seqLength())
	  throw new IllegalArgumentException
	  ("Exon postion is out of bound");
	  
	  if (exonpos[i] > exonpos[i+1])
	  throw new IllegalArgumentException
	  ("Exon postions out of order");  
		
	  if (i > exonpos[0] 
	  && i < exonpos[e - 1]
	  && iscoding[i] == false)
	  throw new IllegalStateException
      ("NonCoding position found");  
	  
	  }
	  
	  if (exonpos[e-1] >= seqLength())
	  throw new IllegalArgumentException
	  ("Exon postion is out of bound");
	  
	 // int  slen = seqLength();
	  int numElements = 0;
	  for (int i = 0; i < e-1; i = i + 2)
	  numElements = numElements + (exonpos[i+1] - exonpos[i] + 1);  

	  char[] exonarr = new char[numElements];

	  int k = 0; int j = 0;
	  for (int i = 0; i < e; i+=2)
	  {
	  for (j = exonpos[i]; j <= exonpos[i+1]; j++)
	  {
		  exonarr[k] = seqarr[j]; 
		  k++;
	  }
	  }
	  
	  return exonarr;
	  
  }

}
