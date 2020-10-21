package edu.iastate.cs228.hw1;

/** @author Cody Fredericks*/

public class CodingDNASequence extends DNASequence
{
	
/** constructs a cdnasequence 
 * @param cdnaarr char array*/
public CodingDNASequence(char[] cdnaarr)
{
  super(cdnaarr);
  for (int i = 0; i < cdnaarr.length; i++)
  if (isValidLetter(cdnaarr[i]) == false)
  throw new IllegalArgumentException
  ("Invalid sequence letter for " + this.getClass());
  
}

/** checks the start of a sequence
 * @return true or false boolean*/
public boolean checkStartCodon()
{
  if (seqLength() < 3) return false;
  if ((seqarr[0] == 'A' || seqarr[0] == 'a')
  && (seqarr[1] == 'T' || seqarr[1] == 't')
  && (seqarr[2] == 'G' || seqarr[2] == 'g')) return true;
  else return false;
}

/** takes the sequence and creates a protein sequence
 * @return condonArr char array */
public char[] translate()
{  
	if (checkStartCodon() == false)  
	throw new RuntimeException("No start codon");
	String ps = ""; String condon = ""; int k = 0;
	for (int i = 0; i < seqLength(); i++)
	{
		for (int j = 0; j < 3; j++)
		{
			if (k == seqLength()) break;
			condon = condon + seqarr[k];
			k++;
		}
		
		if (getAminoAcid(condon) == '$') break; 
		ps = ps + getAminoAcid(condon);
		condon = "";
	}

	int num = 0;
	if (k % 3 != 0) num = ((k - 3)/3) + 1;
	else num = ((k - 3)/3);
	char[] condonArr = new char[num];
	for (int i = 0; i < num; i++) condonArr[i] = ps.charAt(i);
	
	return condonArr;
}

/** gets part of a protein 
 * @param codon string
 * @return aa char */
private char getAminoAcid(String codon)
{
  if ( codon == null ) return '$';
  char aa = '$';
  switch ( codon.toUpperCase() )
  {
    case "AAA": aa = 'K'; break;
    case "AAC": aa = 'N'; break;
    case "AAG": aa = 'K'; break;
    case "AAT": aa = 'N'; break;

    case "ACA": aa = 'T'; break;
    case "ACC": aa = 'T'; break;
    case "ACG": aa = 'T'; break;
    case "ACT": aa = 'T'; break;

    case "AGA": aa = 'R'; break;
    case "AGC": aa = 'S'; break;
    case "AGG": aa = 'R'; break;
    case "AGT": aa = 'S'; break;

    case "ATA": aa = 'I'; break;
    case "ATC": aa = 'I'; break;
    case "ATG": aa = 'M'; break;
    case "ATT": aa = 'I'; break;

    case "CAA": aa = 'Q'; break;
    case "CAC": aa = 'H'; break;
    case "CAG": aa = 'Q'; break;
    case "CAT": aa = 'H'; break;

    case "CCA": aa = 'P'; break;
    case "CCC": aa = 'P'; break;
    case "CCG": aa = 'P'; break;
    case "CCT": aa = 'P'; break;

    case "CGA": aa = 'R'; break;
    case "CGC": aa = 'R'; break;
    case "CGG": aa = 'R'; break;
    case "CGT": aa = 'R'; break;

    case "CTA": aa = 'L'; break;
    case "CTC": aa = 'L'; break;
    case "CTG": aa = 'L'; break;
    case "CTT": aa = 'L'; break;

    case "GAA": aa = 'E'; break;
    case "GAC": aa = 'D'; break;
    case "GAG": aa = 'E'; break;
    case "GAT": aa = 'D'; break;

    case "GCA": aa = 'A'; break;
    case "GCC": aa = 'A'; break;
    case "GCG": aa = 'A'; break;
    case "GCT": aa = 'A'; break;

    case "GGA": aa = 'G'; break;
    case "GGC": aa = 'G'; break;
    case "GGG": aa = 'G'; break;
    case "GGT": aa = 'G'; break;

    case "GTA": aa = 'V'; break;
    case "GTC": aa = 'V'; break;
    case "GTG": aa = 'V'; break;
    case "GTT": aa = 'V'; break;

    case "TAA": aa = '$'; break;
    case "TAC": aa = 'Y'; break;
    case "TAG": aa = '$'; break;
    case "TAT": aa = 'Y'; break;

    case "TCA": aa = 'S'; break;
    case "TCC": aa = 'S'; break;
    case "TCG": aa = 'S'; break;
    case "TCT": aa = 'S'; break;

    case "TGA": aa = '$'; break;
    case "TGC": aa = 'C'; break;
    case "TGG": aa = 'W'; break;
    case "TGT": aa = 'C'; break;

    case "TTA": aa = 'L'; break;
    case "TTC": aa = 'F'; break;
    case "TTG": aa = 'L'; break;
    case "TTT": aa = 'F'; break;
    default:    aa = '$'; break;
  }
  return aa;
}
}