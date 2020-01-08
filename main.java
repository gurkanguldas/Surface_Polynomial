import Matrix.matris;

public class main {
public static void main(String[] args) {
	Class deger = new Class();
	deger.Degisken();
	double A[][]=deger.A();
	double l[]=deger.l();
	
	double AtA[][]=matris.MatMult(matris.Transpose(A), A);
	double invers[][]=matris.invert(AtA);
	double Atl[]=matris.MatMult(matris.Transpose(A), l);
	double X[]=matris.MatMult(invers, Atl);
	Read text = new Read();
	double x[]=text.getX();
	double y[]=text.getY();
	
	matris.print("A ", A, 3, 10);
	matris.print("l ", l, 5, 5);
	matris.print("AtA ", AtA, 5, 15);
	matris.print("Atl ", Atl, 5, 15);
	matris.print("N^-1", invers, 5, 10);
	matris.print("X   ", X, 6, 10);
	
	double a = 0 , b = 0;
	for(int i=0 ; i<A.length ;i++) {
		a+=x[i];
		b+=y[i];
	}
	
	a=a/A.length;
	b=b/A.length;
	
	double c=0 ,f=0;
	
	c=525000;f=4179000;
	c=(a-c)/1000;
	f=(b-f)/1000;
	
	double N= X[0]+X[1]*c+X[2]*f+X[3]*c*c+X[4]*c*f+X[5]*f*f;
	
	System.out.println("\nP1 (N) = "+N);
	
	c=530000;f=4177000;
	c=(a-c)/1000;
	f=(b-f)/1000;
	N= X[0]+X[1]*c+X[2]*f+X[3]*c*c+X[4]*c*f+X[5]*f*f;
	
	System.out.println("P2 (N) = "+N);
	
	double m0=0;
	
	for(int i=0 ; i<A.length ;i++) {
			x[i]=(a-x[i])/1000;
			y[i]=(b-y[i])/1000;
		N= X[0]+X[1]*x[i]+X[2]*y[i]+X[3]*x[i]*x[i]+X[4]*x[i]*y[i]+X[5]*y[i]*y[i];
		m0+=(N-l[i])*(N-l[i]);
	}
	
	System.out.println("\nvtv = "+m0*100+" cm^2");
	
	m0=Math.sqrt(m0/14);
	
	System.out.println("m0 = "+m0*100+" cm");
}
}
