import java.io.*;

public class Edt{
	public static void main(String[] args){
		String[] letters = new String[]{"A","B", "C", "D", "E", "F", "G", "H", "I","J","K","L","M","N"};
		File[] drives = new File[letters.length];
		boolean[] isDrive = new boolean[letters.length];

		//Initialize the file object and the initial Drive state.
		for(int i=0;i<letters.length;++i){
			drives[i] = new File(letters[i] + ":/");
			isDrive[i] = drives[i].canRead();
		}
		
		
		System.out.println("Waiting for devices... Plug IN your USB Device...");
		

		//Infinite Loop
		while(true){
			//checking each drive
			for(int i =0 ; i<letters.length; i++){
				boolean pluggedIn = drives[i].canRead();
	
				//If state changes, output message
				if(pluggedIn != isDrive[i]){
					if(pluggedIn){
						System.out.println("Drive " + letters[i] + " has been plugged In.");
						String totalSpace = drives[i].getTotalSpace()/(1024*1024*1024) + "Gb";
						String freeSpace = drives[i].getFreeSpace()/(1024*1024*1024) + "Gb";
						System.out.println(drives[i].getPath() + "\nTotal Space = " + totalSpace + "\nFree Space = " + freeSpace);
					}
					else{
						System.out.println("Drive " + letters[i] + " has been Un-plugged .");	
					}
					isDrive[i] = pluggedIn;
					System.out.println("Waiting for next change of state...");
				}
			}
			// Wait before looping
			try{Thread.sleep(100);}
			catch(InterruptedException e){}
		}
	}
}