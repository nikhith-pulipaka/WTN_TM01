package com.wipro.eb.main;
import com.wipro.eb.entity.*;
import com.wipro.eb.service.*;
import com.wipro.eb.exception.*;
import java.util.*;
public class Mainclass {

	public static void main(String[] args) throws Exception {
		System.out.println(new ConnectionService().generateBill(130,100,"Commercial"));
		System.out.println(new ConnectionService().generateBill(130,100,"Domestic"));
		System.out.println(new ConnectionService().generateBill(100,130,"Domestic"));
		System.out.println(new ConnectionService().generateBill(-20,100,"Domestic"));
		System.out.println(new ConnectionService().generateBill(200,-35,"Domestic"));
		System.out.println(new ConnectionService().generateBill(1200,800,"Commercial"));
		System.out.println(new ConnectionService().generateBill(1200,800,"MYTYPE"));
	}

}

