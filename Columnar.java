import java.util.*;

class Columnar{

      public static void main(String sap[]){
      Scanner sc = new Scanner(System.in);

      System.out.print("\nEnter plaintext(enter in lower case): ");
      String message = sc.nextLine();
	  System.out.print("\nEnter key in numbers: ");
      String key = sc.nextLine();
	  int columnCount = key.length();

      int rowCount = (message.length()+columnCount)/columnCount;

      int plainText[][] = new int[rowCount][columnCount];
      int cipherText[][] = new int[rowCount][columnCount];
 
	  //Encryption Process
	  
	  cipherText = encrypt(plainText, cipherText, message, rowCount, columnCount, key);
		
	  String ct = "";
      for(int i=0; i<columnCount; i++)
      {
           for(int j=0; j<rowCount; j++)
           {
                 if(cipherText[j][i] == 0)
                      ct = ct + 'x';
                 else{
                      ct = ct + (char)cipherText[j][i];
                 }
           }
      }
      System.out.print("\nCipher Text: " + ct);
		
	  //Decryption Process	
	
	  plainText = decrypt(plainText, cipherText, ct, rowCount, columnCount, key);
	
	  
	
	}

    static int[][] encrypt(int plainText[][], int cipherText[][], String message, int rowCount, int columnCount, String key){
          
		  int i,j;
          int k=0;

           for(i=0; i<rowCount; i++)
           {
                for(j=0; j<columnCount; j++)
                {
                      if(k < message.length())
                      {
                             plainText[i][j] = (int)message.charAt(k);
                             k++;
                      }
                      else
                      {
                             break;
                      }
                }
           }
	      for(i=0; i<columnCount; i++)
          {
                int currentCol= ( (int)key.charAt(i) - 48 ) -1;
                for(j=0; j<rowCount; j++)
                {
                      cipherText[j][i] = plainText[j][currentCol];
                }
           }
          System.out.print("Cipher Array(read column by column): \n");
          for(i=0;i<rowCount;i++){
                for(j=0;j<columnCount;j++){
                      System.out.print((char)cipherText[i][j]+"\t");
                }
                System.out.println();
          }

          return cipherText;
     }

     static int[][] decrypt(int plainText[][], int cipherText[][], String message, int rowCount, int                                                                                                          columnCount, String key){
            int i,j;
            int k=0;

            for(i=0; i<columnCount; i++)
            {
                  int currentCol= ( (int)key.charAt(i) - 48 ) -1;
                  for(j=0; j<rowCount; j++)
                  {
                        plainText[j][currentCol] = cipherText[j][i];
                  } 
            }

            System.out.print("Plain Array(read row by row): \n");
            for(i=0;i<rowCount;i++){
                 for(j=0;j<columnCount;j++){
                        System.out.print((char)plainText[i][j]+"\t");
                 }
                 System.out.println();
            }

           return plainText;
      }
}