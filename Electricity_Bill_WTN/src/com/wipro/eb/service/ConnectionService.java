
package com.wipro.eb.service;
import com.wipro.eb.entity.*;
import com.wipro.eb.exception.*;
public class ConnectionService {
	public boolean validate(int currentReading,int previousReading,String type)throws Exception{
		boolean result=true;
		if((currentReading<previousReading)||currentReading<0 || previousReading<0) {
			//result=false;
			throw new InvalidReadingException();
		}
		if(!((type.equalsIgnoreCase("Domestic"))||(type.equalsIgnoreCase("Commercial")))) {
			//result=false;
			throw new InvalidConnectionException();
		}
		return result;
	}
	public float calculateBillAmt(int cr,int pr,String type) throws Exception{
		float result=0;
		try {
			if(this.validate(cr, pr, type)) {
				Connection c;
				if(type.equalsIgnoreCase("Commercial")) {
					c=new Commercial(cr,pr);
				}
				else {
					c=new Domestic(cr,pr);
				}
				result=c.computeBill();
			}
		}
		catch(InvalidReadingException ire) {
			result=-1;
		}
		catch(InvalidConnectionException ice) {
			result=-2;
		}
		return result;
	}
	public String generateBill(int cr,int pr,String type) throws Exception{
		float result=this.calculateBillAmt(cr, pr,type);
		if(result==-1) {
			return("Invalid reading");
		}
		else if(result==-2) {
			return("Invalid Connection type");
		}
		return(String.format("Amount to be paid:%.2f",result));
	}
}
