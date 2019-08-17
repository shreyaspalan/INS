import java.util.*;

public class CaesarCipher{
	
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		String plainText = sc.nextLine();
		int key  = sc.nextInt();
		String cipherText = encryption(plainText, key%26);
		System.out.println(cipherText);
	
		String returnText = decryption(cipherText , key%26);
		System.out.println(plainText);
		
	}
	
	static String encryption(String plainText,int key){
		String cipherText = "";
		for(int i = 0; i<plainText.length();i++){
				
				if(plainText.charAt(i) >= 65 && plainText.charAt(i) <= 90){
				
					int cipherChar = (int)plainText.charAt(i) + key;
					if(cipherChar > 90){
						cipherChar -= 26;
					}
					else if(cipherChar < 65){
						cipherChar += 26;
					}
					cipherText += (char)cipherChar;	
				}
				else if(plainText.charAt(i) >= 97 && plainText.charAt(i) <= 122){
				
					int cipherChar = (int)plainText.charAt(i) + key;
					if(cipherChar > 122){
						cipherChar -= 26;
					}
					else if(cipherChar < 97){
						cipherChar += 26;
					}
					
					cipherText += (char)cipherChar;	
				}
				else{
					cipherText += plainText.charAt(i);	
				}
		}	
				return cipherText;
			
	}
	
	static String decryption(String cipherText, int key){
			String plainText = "";
		//	System.out.println(cipherText);
		for(int i = 0; i<cipherText.length();i++){

			if(cipherText.charAt(i) >= 65 && cipherText.charAt(i) <= 90){
				
					int plainChar = (int)cipherText.charAt(i) - key;
					//System.out.println(plainChar);
					if(plainChar > 90){
						plainChar -= 26;
					}
					else if(plainChar < 65){
						plainChar += 26;
					}
					plainText += plainChar;	
			}
			else if(cipherText.charAt(i) >= 97 && cipherText.charAt(i) <= 122){
				
					int plainChar = (int)cipherText.charAt(i) - key;
					if(plainChar > 122){
						plainChar -= 26;
					}
					else if(plainChar < 97){
						plainChar += 26;
					}
					
					plainText += (char)plainChar;	
			}
			else{
					plainText += cipherText.charAt(i);	
			}
		}
			return plainText;
		
	}
	
}	
	
