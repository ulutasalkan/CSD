package Homework_Java_014;

import java.util.Scanner;

public class ConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Console c=new Console();
		c.run();
	}
}
enum Commands{
	length,reverse,upper,lower,quit
}
class Console{
	private int getCommand(String s){		
		boolean status=false;
		int result=0;
		for(int i=0;i<Commands.values().length;i++){			
			if(s.length()>Commands.values()[i].toString().length())
				continue;			
			for(int j=0;j<s.length();j++){				
				if(s.charAt(j)!=Commands.values()[i].toString().charAt(j)){
					status=false;
					break;
				}							
				else
					status=true;
			}
			if(status){
				result=i;
				break;
			}
		}
		if(status)
			return result;
		return -1;
	}
	private boolean control(String s){		
		if(s.length()<3){
			System.out.println("Komutun ilk üç karakteri zorunludur.");
			return false;
		}			
		return true;
	}
	private int length(String s){
		return s.length();
	}
	private void reverse(String s){
		char[] c=s.toCharArray();
		char temp;
		for(int i=0;i<c.length/2;i++){
			temp=c[i];
			c[i]=c[c.length-i-1];
			c[c.length-i-1]=temp;
		}
		for(char newC:c)
			System.out.print(newC);		
		System.out.println("");
	}
	private String upper(String s){
		return s.toUpperCase();
	}
	private String lower(String s){
		return s.toLowerCase();
	}
	public void run(){
		Scanner kb=new Scanner(System.in);
		String cmd="";
		String cmd1="";
		String s="";
		for(;;){
			System.out.print("CSD>");
			cmd=kb.nextLine();
			int i=0;
			for(;i<cmd.length();i++)			
				if(cmd.charAt(i)=='"'){
					cmd1=cmd.substring(0,i);
					break;
				}			
			for(int j=i+1;j<cmd.length();j++)
				if(cmd.charAt(j)=='"'){
					s=cmd.substring(i+1,j);
					break;
				}
			if(!control(cmd1.trim()))
				continue;
			if(getCommand(cmd1.trim())==-1){
				System.out.println("Geçersiz komut girdiniz.");
				continue;
			}
			else{
				if(getCommand(cmd1.trim())==Commands.length.ordinal())
					System.out.println(length(s));
				if(getCommand(cmd1.trim())==Commands.lower.ordinal())
					System.out.println(lower(s));
				if(getCommand(cmd1.trim())==Commands.upper.ordinal())
					System.out.println(upper(s));
				if(getCommand(cmd1.trim())==Commands.reverse.ordinal())
					reverse(s);
				if(getCommand(cmd1.trim())==Commands.quit.ordinal()){
					System.out.println("Çýkýþ yaptýnýz!!!");
					System.exit(-1);
				}
			}
		}
	}

}
