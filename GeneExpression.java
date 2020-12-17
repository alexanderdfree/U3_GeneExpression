public class GeneExpression{
   public static String unzipDNA(String cDNA){
      /*Given a coding DNA strand (in 5'-3' order)
      generate the corresponding template strand
     
      Return the template strand in 5'-3' order
          
      Input:
         String cDNA: the coding DNA sequence in 5'-3' order
      Output:
         return: the template DNA sequence in 5'-3' order
     
      Ex.
            (coding)
      5'  ATGATCTCGTAA  3'
      3'  TACTAGAGCATT  5'
           (template)
     
      unzipDNA("ATGATCTCGTAA") -> "TTACGAGATCAT"
      */
   String tot = "";
   for (int i = 0; i < cDNA.length(); i++){
   String s = cDNA.substring(i, i+1);
   if (s.equals("A")) {
      tot+= "T";
   }
   if (s.equals("T")) {
      tot+= "A";
   }
   if (s.equals("C")) {
      tot+= "G";
   }
   if (s.equals("G")) {
      tot+= "C";
   }
   }
   String tot2 = "";
   for (int i = tot.length() -1; i >= 0; i--){
      tot2 += tot.substring(i, i+1); }
   return tot2;
}
public static void unzipTest(){
   Testing.testEquals("Test 1", unzipDNA("A"), "T");
   Testing.testEquals("Test 2", unzipDNA("GATCAT"), "ATGATC");
   Testing.testEquals("Test 3", unzipDNA("ATGATCTCGTAA"), "TTACGAGATCAT");
}
public static void transcribeTest(){
   Testing.testEquals("Test 1", transcribeRNA("A"), "U");
   Testing.testEquals("Test 2", transcribeRNA("GATCAT"), "AUGAUC");
   Testing.testEquals("Test 3", transcribeRNA("TAC"), "GUA");
}
public static void aminoTest(){
   Testing.testEquals("Test 1", translateAmino("AUGAUCUCGUAA"), "MIS");
   Testing.testEquals("Test 2", translateAmino("AAGCAU"), "KH");
   Testing.testEquals("Test 3", translateAmino("AAA"), "K");
}
public static String transcribeRNA(String tDNA){
      /*Transcribe DNA to RNA. Given a template strand
      of DNA, returns the resulting RNA sequence in 5'-3' order
     
      Input:
         tDNA: template DNA strand in 5'-3' order
      Output:
         return: RNA strand in 5'-3' order
     
      Ex.
           (DNA)
      5'  GATCAT   3'
      3'  CUAGUA   5'     
           (RNA)
     
      transcribeRNA("GATCAT") -> "AUGAUC"
      */
   String tot = "";
   String tot2 = "";
   for (int i = 0; i < tDNA.length(); i++){
   String s = tDNA.substring(i, i+1);
   if (s.equals("A")) {
      tot+= "U";
   }
   if (s.equals("T")) {
      tot+= "A";
   }
   if (s.equals("C")) {
      tot+= "G";
   }
   if (s.equals("G")) {
      tot+= "C";
   }
   }
   for (int i = tot.length() -1; i >= 0; i--){
      tot2 += tot.substring(i, i+1);
   }
   return tot2;
}
public static String translateAmino(String mRNA){
      /*Translate mRNA to an amino acid sequence.
      If you see a STOP codon, stop translating,
      otherwise, translate the whole sequence
     
      Input:
         String mRNA: an mRNA sequence in 5'-3' order
      Output:
         return: corresponding amino acid sequence
        
      Ex.
      translateAmino("AUGAUCUCGUAA") -> "MIS"
      */
   String tot = "";
   for (int i = 0; i < mRNA.length(); i+=3){
   String s = mRNA.substring(i, i+3);
   if (s.equals("UGA") || s.equals("UAA") || s.equals("UAG")) {
      break;
   }
   else if (s.equals("UUU") || s.equals("UUC")) {
      tot+= "F";
   }
   else if (s.equals("UUA") || s.equals("UUG") || s.equals("CUU")|| s.equals("CUC")|| s.equals("CUA")|| s.equals("CUG") ) {
      tot+= "L";
   }
   else if (s.equals("AUU") || s.equals("AUC") || s.equals("AUA")) {
      tot+= "I";
   }
   else if (s.equals("AUG")) {
      tot+= "M";
   }
   else if (s.equals("GUU") || s.equals("GUC") || s.equals("GUA")|| s.equals("GUG")) {
      tot+= "V";
   }
   else if (s.equals("UCU")|| s.equals("UCC")|| s.equals("UCA")|| s.equals("UCG")) {
      tot+= "S";
   }
   else if (s.equals("CCU")|| s.equals("CCA")|| s.equals("CCG")|| s.equals("CCC") ) {
      tot+= "P";
   }
   else if (s.equals("ACU")|| s.equals("ACC")|| s.equals("ACA")|| s.equals("ACG")) {
      tot+= "T";
   }
   else if (s.equals("GCU") || s.equals("GCC")|| s.equals("GCA")|| s.equals("GCG")) {
      tot+= "A";
   }
   else if (s.equals("UAU") || s.equals("UAC")) {
      tot+= "Y"; }
   else if (s.equals("CAU") || s.equals("CAC")) {
      tot+= "H"; }
   else if (s.equals("CAA") || s.equals("CAG")) {
      tot+= "Q"; }
   else if (s.equals("AAU") || s.equals("AAC")) {
      tot+= "N"; }
   else if (s.equals("AAA") || s.equals("AAG")) {
      tot+= "K"; }
   else if (s.equals("GAU") || s.equals("GAC")) {
      tot+= "D"; 
   }
   else if (s.equals("GAA") || s.equals("GAG")) {
      tot+= "E"; 
   }
   else if (s.equals("UGU") || s.equals("UGC")) {
      tot+= "C"; 
   }
   else if (s.equals("UGG")) {
      tot+= "W"; 
   }
   else if (s.equals("CGU") || s.equals("CGC")|| s.equals("CGA")|| s.equals("CGG")|| s.equals("AGA")|| s.equals("AGG")) {
      tot+= "R"; 
   }
   else if (s.equals("AGU") || s.equals("AGC")) {
      tot+= "S"; 
   }
   else if (s.equals("GGU") || s.equals("GGC")|| s.equals("GGA")|| s.equals("GGG")) {
      tot+= "G"; 
   }

   }
   return tot;
}
public static void main(String[] args){
      /*
      1) Read a DNA coding strand from StdIn
      2) Unzip the DNA to get the template strand
      3) Transcribe mRNA from the template strand
      4) Translate the mRNA to amino acids
      5) Print the amino acid sequence to StdOut
      */
   String input1 = StdIn.readString();
   String template = GeneExpression.unzipDNA(input1);
   String mRNA = GeneExpression.transcribeRNA(template);
   String amino = GeneExpression.translateAmino(mRNA);
   StdOut.println(amino);
}
}