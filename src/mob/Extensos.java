package mob;

public class Extensos {
	private static String numBasic[]={"ZERO","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE",
		"TEN","ELEVEN","TWELVE","THIRTEEN","FOURTEEN","FIFTEEN","SIXTEEN","SEVENTEEN","EIGHTEEN","NINETEEN"};
	private static String dezenas[]={"TWENTY","THIRTY","FORTY","FIFTY","SIXTY","SEVENTY","EIGHTY","NINETY","ONE HUNDRED"};
	private static String centenas[]={"ONE HUNDRED","TWO HUNDRED","THREE HUNDRED","FOUR HUNDRED","FIVE HUNDRED","SIX HUNDRED","SEVEN HUNDRED",
		"EIGHT HUNDRED","NINE HUNDRED"};
	public Extensos() {

	}

	public static String numExt(int	num) throws	IllegalArgumentException{
		String extenso="";

		//		if(num<0 || num>999999999)
		//			throws new IllegalArgumentException();
		if(num==0)
			return numBasic[0];

		if(num>=1000 && num<=9999){
			if(num/1000>1)
				extenso += numBasic[num/1000]+" ";
			if(num%1000==0 && num%100==0 &&num%10==0){
				extenso += "THOUSAND";
				return extenso;
			}
			extenso += "THOUSAND ";
			if((num%1000==0) || (num%1000>=1)&&(num%100==0)&&(num%10==0)){
				extenso +=" ";				
			}
			num=num%1000;
		}

		if(num>100 && num<=999){
			extenso += centenas[num/100-1];
			if(num%100!=0)
				extenso +=" ";
			num=num%100;
		}

		if(num>=20 && num<=100){
			extenso+= dezenas[num/10-2];
			if(num%10!=0)
				extenso +=" ";
			num=num%10;
		}
		if(num<20 && num>0)
			extenso+= numBasic[num];

		return extenso;
	}

}
