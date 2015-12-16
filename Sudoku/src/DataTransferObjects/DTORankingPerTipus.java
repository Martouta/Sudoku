package DataTransferObjects;

public class DTORankingPerTipus {
	
	String f1,f2,f3,m1,m2,m3,d1,d2,d3;
	
	public DTORankingPerTipus(String fac1, String fac2, String fac3, String med1, String med2, String med3, String dif1, String dif2, String dif3){
		f1=fac1;
		f2=fac2;
		f3=fac3;
		m1=med1;
		m2=med2;
		m3=med3;
		d1=dif1;
		d2=dif2;
		d3=dif3;
	}
	
	public String getf1(){
		return f1;
	}
	
	public String getf2(){
		return f2;
	}
	
	public String getf3(){
		return f3;
	}
	
	public String getm1(){
		return m1;
	}
	
	public String getm2(){
		return m2;
	}
	
	public String getm3(){
		return m3;
	}
	
	public String getd1(){
		return d1;
	}
	
	public String getd2(){
		return d2;
	}
	
	public String getd3(){
		return d3;
	}
}
