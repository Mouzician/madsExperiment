
public class Extensos {
	private static String numBasic[]={"ZERO","UM","DOIS","TRÊS","QUATRO","CINCO","SEIS","SETE","OITO","NOVE",
		"DEZ","ONZE","DOZE","TREZE","QUATORZE","QUINZE","DEZASEIS","DEZASETE","DEZOITO","DEZANOVE"};
	private static String dezenas[]={"VINTE","TRINTA","QUARENTA","CINQUENTA","SESSENTA","SETENTA","OITENTA","NOVENTA","CEM"};
	private static String centenas[]={"CENTO","DUZENTOS","TREZENTOS","QUATROCENTOS","QUINHENTOS","SEISSENTOS","SETECENTOS",
		"OITOCENTOS","NOVECENTOS"};
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
				extenso += "MIL";
				return extenso;
			}
			extenso += "MIL ";
			if((num%1000==0) || (num%1000>=1)&&(num%100==0)&&(num%10==0)){
				extenso +="E ";				
			}
			num=num%1000;
		}

		if(num>100 && num<=999){
			extenso += centenas[num/100-1];
			if(num%100!=0)
				extenso +=" E ";
			num=num%100;
		}

		if(num>=20 && num<=100){
			extenso+= dezenas[num/10-2];
			if(num%10!=0)
				extenso +=" E ";
			num=num%10;
		}
		if(num<20 && num>0)
			extenso+= numBasic[num];

		return extenso;
	}

}
