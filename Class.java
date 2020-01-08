import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Matrix.matris;

public class Class {
	private static double A[][],l[];
	public  void Degisken(){
	Read text = new Read();
	double x[]=text.getX(),
		   y[]=text.getY(),
		   N[]=text.getN();
	int cols = x.length;
	double X = 0,Y = 0;
	for(int i=0 ; i<cols ;i++) {
		X+=x[i];
		Y+=y[i];
	}
	X=X/cols;
	Y=Y/cols;
	//a0+a1x+a2y+a3xy+a4x2+a5y2
	double A[][]= new double[cols][6];
	double l[]=new double[cols];
	for(int i=0 ; i<cols ;i++) {
		A[i][0]=1;
		A[i][1]=(X-x[i])/1000;
		A[i][2]=(Y-y[i])/1000;
		A[i][3]=((X-x[i])/1000)*((X-x[i])/1000);
		A[i][4]=((X-x[i])/1000)*((Y-y[i])/1000);
		A[i][5]=((Y-y[i])/1000)*((Y-y[i])/1000);
		l[i]=N[i];
	}
	this.A=A;
	this.l=l;
	}
	public  double[][] A() {
		return this.A;
	}
	public  double[] l() {
		return this.l;
	}
	
}
class Read {
	private double x[], y[], N[];
	Read() {
		File text = new File("E:\\Desktop\\DengelemedeOzelKonular\\Jeoit_Modelleme\\Odev_1\\data.txt");
		BufferedReader buffer;
		double x[], y[], N[];
		N=new double[20];
		x=new double[20];
		y=new double[20];
		int j=0;
		try {
			buffer = new BufferedReader(new FileReader(text));
			String okuma =buffer.readLine();
			
			while(okuma!=null) {
				N[j]=Double.parseDouble(okuma.substring(23,okuma.length()));
				x[j]=Double.parseDouble(okuma.substring(0,10));
				y[j]=Double.parseDouble(okuma.substring(10,23));
					j++;
				okuma= buffer.readLine();
			}
			buffer.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.N=N;
		this.x=x;
		this.y=y;}
	
	public double[] getN() {
		return this.N;
	}
	public double[] getX() {
		return this.x;
	}
	public double[] getY() {
		return this.y;
	}
}
