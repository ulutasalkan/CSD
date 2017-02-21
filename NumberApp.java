package Homework_Java_014;

import java.util.Scanner;

public class NumberApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb=new Scanner(System.in);
		System.out.print("Okunuþunu görmek istediðiniz sayýyý giriniz: ");
		int val=kb.nextInt();
		NumberDef def=new NumberDef(val);
		def.displayDefinition();
		kb.close();
	}
}
class NumberDef{
	private String[] m_birler={"","bir","iki","üç","dört","beþ","altý","yedi","sekiz","dokuz"};
	private String[] m_onlar={"","on","yirmi","otuz","kýrk","elli","altmýþ","yetmiþ","seksen","doksan"};
	private int m_val=0;
	NumberDef(int val){
		m_val=val;
	}		
	private String getDefOfNum(){
		int res=0;
		String result="";		
		if(m_val/100_000_000!=0){
			res=m_val/100_000_000;
			if(res>1)
				result+=m_birler[res]+" ";
			result+="yüz ";
			m_val=m_val%100_000_000;
		}
		if(m_val/10_000_000!=0){
			res=m_val/10_000_000;
			if(res>=1)
				result+=m_onlar[res]+" ";			
			m_val=m_val%10_000_000;
		}
		if(m_val/1_000_000!=0){
			res=m_val/1_000_000;
			if(res>=1)
				result+=m_birler[res]+" ";
			m_val=m_val%1_000_000;
		}
		result+="milyon ";		
		if(m_val/100000!=0){
			res=m_val/100000;
			if(res>1)
				result+=m_birler[res]+" ";
			result+="yüz ";	
			m_val=m_val%100000;					
		}
		if(m_val/10000!=0){
			res=m_val/10000;
			if(res>=1){
				result+=m_onlar[res]+" ";
				m_val=m_val%10000;
				if(m_val/1000!=0){
					res=m_val/1000;
					if(res>=1)
						result+=m_birler[res]+" ";					
				}
				result+="bin ";				
				m_val=m_val%1000;					
			}			
		}
		if(m_val/1000!=0){
			res=m_val/1000;
			if(res>1)
				result+=m_birler[res]+" ";					
		}
		if(m_val/100!=0){
			res=m_val/100;
			if(res>1)
				result+=m_birler[res]+" ";
			result+="yüz ";
			m_val=m_val%100;
		}
		if(m_val/10!=0){
			res=m_val/10;
			if(res>=1)
				result+=m_onlar[res]+" ";			
			m_val=m_val%10;
		}
		if(m_val!=0)
			result+=m_birler[m_val];
		return result;
	}
	public void displayDefinition(){
		System.out.println(getDefOfNum());		
	}		
}