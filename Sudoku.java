package Homework_Java_015;

import java.util.Scanner;

public class Sudoku {
	private int[][] m_sdm;
	public Sudoku() {
		// TODO Auto-generated constructor stub
		m_sdm=new int[9][9];
	}
	public void read(){
		// Klavyeden okuma yap ve matrise yerleþtir
		Scanner kb=new Scanner(System.in);				
		for(int i=0;i<m_sdm.length;i=i+1)
			for(int j=0;j<m_sdm.length;j=j+1)
				m_sdm[i][j]=kb.nextInt();
		kb.close();
	}
	private void display(){
		for(int[] a: m_sdm){
			for(int b: a)
				System.out.print(b);
			System.out.println();
		}
	}
	public boolean isValid(){		
		return checkAllColumns() && checkAllRows() && checkThreeByThreeMatrix();
	}
	private boolean checkThreeByThreeMatrix(){
		boolean[] b=new boolean[m_sdm.length+1];
		boolean result=true;
		EXIT_LOOP:
		for(int i=0;i<m_sdm.length;i=i+3){
			b=new boolean[m_sdm.length+1];
			for(int j=0;j<m_sdm.length;j=j+1){
				if(j%3==0 && j!=0){
					for(int a=1;a<b.length;a++){
						if(b[a]==false){	
							result=false;
							break EXIT_LOOP;
						}
					}						
					b=new boolean[m_sdm.length+1];
				}
				for(int k=0;k<3;k++)
					b[m_sdm[j][i+k]]=!b[m_sdm[j][i+k]];							
			}	
		}
		return result;
	}
	private boolean checkColumn(int val){
		boolean[] b=new boolean[m_sdm.length+1];				
		boolean result=true;
		for(int i=0;i<m_sdm.length;i++)
			b[m_sdm[i][val]]=!b[m_sdm[i][val]];
		for(int i=1;i<b.length;i++)
			if(b[i]==false){
				result=false;
				break;
			}
		return result;
	}
	private boolean checkRow(int val){
		boolean[] b=new boolean[m_sdm.length+1];				
		boolean result=true;
		for(int i=0;i<m_sdm.length;i++)
			b[m_sdm[val][i]]=!b[m_sdm[val][i]];
		for(int i=1;i<b.length;i++)
			if(b[i]==false){
				result=false;
				break;
			}
		return result;
	}
	private boolean checkAllRows(){
		boolean result=true;
		for(int i=0;i<m_sdm[0].length;i++)
			if(!checkRow(i)){
				result=false;
				break;
			}
		return result;
	}
	private boolean checkAllColumns(){
		boolean result=true;
		for(int i=0;i<m_sdm[0].length;i++)
			if(!checkColumn(i)){
				result=false;
				break;
			}
		return result;
	}

}
