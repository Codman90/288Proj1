package edu.iastate.cs228.hw1;
/** @author Cody Fredericks*/

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SequenceTest
{
	@Test
	public void test()
	{
		String demodna = new String("AATGCCAGTCAGCATAGCGTAGACT");
	    int[] ardemo = {1, 5, 8, 10, 13, 16};
	    GenomicDNASequence gdemo = new GenomicDNASequence(demodna.toCharArray());
		
	    assertEquals("AATGCCAGTCAGCATAGCGTAGACT", gdemo.toString());
	    assertEquals(25, gdemo.seqLength());
	    
	    gdemo.markCoding(1, 16);
	    CodingDNASequence cdemo = new CodingDNASequence(gdemo.extractExons(ardemo));
		
	    assertEquals("ATGCCTCAATAG", cdemo.toString());
	    
	    if (cdemo.checkStartCodon())
	    {
	      System.out.println( "It has a start codon");
	      ProteinSequence aademo = new ProteinSequence( cdemo.translate() );
	      assertEquals("MPQ", aademo.toString());
	
	    }

	    
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void test2()
	{

	  String probst = new String("T$G");
	  Sequence seqobj = new Sequence( probst.toCharArray() );
	  	  
  	  String probst2 = new String("TDG");
	  DNASequence dnaseqobj = new DNASequence( probst2.toCharArray() );

	  String probst3 = new String("TGCH");
	  GenomicDNASequence gdnaobj = new GenomicDNASequence( probst3.toCharArray());

	  String probst4 = new String("BJU");
	  ProteinSequence probj = new ProteinSequence( probst4.toCharArray());
	  
	  
	  String demodna = new String("AATGCCAGTCAGCATAGCGTAGAC");
	  GenomicDNASequence g = new GenomicDNASequence(demodna.toCharArray());
	  g.markCoding(0, -1);
	  int[] ardemo = {-1, 8, 5, 13, 50};
	  g.extractExons(ardemo);
	  

	}

	@Test (expected = IllegalStateException.class)
    public void test3()
    {
		  String demodna = new String("AATGCCAGTCAGCATAGCGTAGACT");
		  GenomicDNASequence g = new GenomicDNASequence(demodna.toCharArray());
		  g.markCoding(0, 0);
		  int[] ardemo = {1, 5, 8, 10, 13, 16};
		  g.extractExons(ardemo);
		  
    }
	
	
	
	
	
	
	
}
