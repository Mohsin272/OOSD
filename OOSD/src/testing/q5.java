package testing;

public class q5 {
	
	public static double f(double x){
	 return g(x) + Math.sqrt(h(x)); }
	
	public static double g(double x){
	 return 4 * h(x); }
	
	public static double h(double x){ 
	return x * x + k(x) - 1; }
	
	public static double k(double x){
	 return 2 * (x + 1); }

	public static void main(String[] args) {
		System.out.println( f(2) );
	}

}
