import java.util.*;
class Playfair{
	public static void main(String args[]){
		char [][] playMatrix = new char[5][5];
		String plainText = "trojan";
		String key = "aapex";
		String alpha = "abcdefghiklmnopqrstuvwxyz";
		key = key+alpha;
		int k=0;
		
		StringBuilder sb = new StringBuilder();
		key.chars().distinct().forEach(c -> sb.append((char)c));
		
		HashMap<Character,Integer> charMap = new HashMap<Character,Integer>();
		
		for(int i=0;i<sb.length();i++){
			charMap.put(sb.charAt(i),i+1);
		}
		charMap.put('j',11);
		
		HashMap<Integer,Character> numMap = new HashMap<Integer,Character>();
		
		for(int i=0;i<sb.length();i++){
			numMap.put(i+1,sb.charAt(i));
		}
		numMap.put(11,'j');
		String cipher = new String();
		
		for(int i=0;i<plainText.length()-1;i=i+2){
			//temp for index
			int temp1 = charMap.get(plainText.charAt(i));
			int temp2 = charMap.get(plainText.charAt(i+1));
			
			if((temp1-temp2)%5==0){
				temp1 = temp1+5;
				temp2 = temp2+5;
				if((temp1>25)){
					temp1 = temp1-20;
				}
				if((temp2>25)){
					temp1 = temp1-20;
				}
				
				cipher = cipher+Character.toString(numMap.get(temp1))+Character.toString(numMap.get(temp2));
			}
			else if((temp1-1)/5==(temp2-1)/5){
				if(temp2%5==0){
					temp2=temp2-4;
				}
				else{
						temp2 = temp2+1;
				}
				if(temp1%5==0){
					temp1=temp1-4;
				}
				else{
						temp1 = temp1+1;
				}
				cipher = cipher+Character.toString(numMap.get(temp1))+Character.toString(numMap.get(temp2));
			}
			else{
				int a,b;
				a = temp1%5;
				b = temp2%5;
				System.out.print(a + " "+ b);
				if(a<b){
					
					temp1= temp1+a;
				temp2= temp2-b;
				cipher = cipher+Character.toString(numMap.get(temp1))+Character.toString(numMap.get(temp2));
			
				}
				else{
					temp1= temp1-a;
					temp2= temp2+b;
					cipher = cipher+Character.toString(numMap.get(temp1))+Character.toString(numMap.get(temp2));
			
				}
				}
		}
		
		String decrypt;
		for(int i=0;i<plainText.length()-1;i=i+2){
			//temp for index
			int temp1 = charMap.get(cipher.charAt(i));
			int temp2 = charMap.get(cipher.charAt(i+1));
			
			if((temp1-temp2)%5==0){
				temp1 = temp1-5;
				temp2 = temp2-5;
				if((temp1<1)){
					temp1 = temp1+20;
				}
				if((temp2>1)){
					temp1 = temp1+20;
				}
				
				decrypt = decrypt+Character.toString(numMap.get(temp1))+Character.toString(numMap.get(temp2));
			}
			else if((temp1-1)/5==(temp2-1)/5){
				if(temp2%5==0){
					temp2=temp2+4;
				}
				else{
						temp2 = temp2+1;
				}
				if(temp1%5==0){
					temp1=temp1-4;
				}
				else{
						temp1 = temp1-1;
				}
				decrypt = decrypt+Character.toString(numMap.get(temp1))+Character.toString(numMap.get(temp2));
			}
			else{
				int a,b;
				a = temp1%5;
				b = temp2%5;
				//System.out.print(a + " "+ b);
				if(a<b){
					
					temp1= temp1-a;
				temp2= temp2+b;
				decrypt = decrypt+Character.toString(numMap.get(temp1))+Character.toString(numMap.get(temp2));
			
				}
				else{
					temp1= temp1+a;
					temp2= temp2-b;
					decrypt = decrypt+Character.toString(numMap.get(temp1))+Character.toString(numMap.get(temp2));
			
				}
				}
		}
		
		
		
		System.out.println("Encrypted message :");
		System.out.println(cipher);
		System.out.println("Decrypted message :");
		System.out.println(decrypt);
	}
}

