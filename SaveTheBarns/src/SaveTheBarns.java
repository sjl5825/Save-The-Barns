/* 
 * This project writes detailed forms
 * Spenser Lehman 
 * 12/14/2019
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SaveTheBarns {
	
	static Scanner myScanner;
	static String iContributorName;
	static String iAddress;
	static String iState;
	static String iZip;
	static String iString;
	static String iParty;
	static String iGender;
	static String iCity;
	static double iContribution;
	static boolean error = false;
	static Scanner filescanner;
	static PrintWriter pw;
	static PrintWriter pw2;
	static String iString3;
	static boolean eof = false;
	static String invalid;
	static NumberFormat nf;
	
	//men 
	static int cmenctr = 0;
	static String omenctr;
	static double cavgmen = 0.0;
	static String oavgmen;
	static double cmentotcon = 0.0;
	static String omentotcon;
	//women
	static int cwomenctr = 0;
	static String owomenctr;
	static double cavgwomen = 0.0;
	static String oavgwomen;
	static double cwomentotcon = 0.0;
	static String owomentotcon;
	//democrats
	static int cdemoc = 0;
	static String odemoc;
	static double cavgdemoc = 0.0;
	static String oavgdemoc;
	static double cdemototcon = 0.0;
	static String odemototcon;
	//republicans
	static int crep = 0;
	static String orep;
	static double cavgrep = 0.0;
	static String oavgrep;
	static double creptotcon = 0.0;
	static String oreptotcon;
	//independents
	static int cind = 0;
	static String oind;
	static double cavgind = 0.0;
	static String oavgind;
	static double cindtotcon = 0.0;
	static String oindtotcon;
	//democratic men
	static int cdemomen = 0;
	static String odemomen;
	static double cavgdemomen = 0.0;
	static String oavgdemomen;
	static double cdemomentotcon = 0.0;
	static String odemomentotcon;
	//democratic women
	static int cdemowomen = 0;
	static String odemowomen;
	static double cavgdemowomen = 0.0;
	static String oavgdemowomen;
	static double cdemowomentotcon = 0.0;
	static String odemowomentotcon;
	//republican men
	static int crepmen = 0;
	static String orepmen;
	static double cavgrepmen = 0.0;
	static String oavgrepmen;
	static double crepmentotcon = 0.0;
	static String orepmentotcon;
	//republican women
	static int crepwomen = 0;
	static String orepwomen;
	static double cavgrepwomen = 0.0;
	static String oavgrepwomen;
	static double crepwomentotcon = 0.0;
	static String orepwomentotcon;
	//independent men
	static int cindmen = 0;
	static String oindmen;
	static double cavgindmen = 0.0;
	static String oavgindmen;
	static double cindmentotcon = 0.0;
	static String oindmentotcon;
	//independent women
	static int cindwomen = 0;
	static String oindwomen;
	static double cavgindwomen = 0.0;
	static String oavgindwomen;
	static double cindwomentotcon = 0.0;
	static String oindwomentotcon;
	//overall
	static int coverall = 0;
	static String ooverall;
	static double cavgoverall = 0.0;
	static String oavgoverall;
	static double coveralltotcon = 0.0;
	static String ooveralltotcon;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		init();
		
		while (eof == false) {
		
		input();
		
		if (!error) {

		calcs();
		
		}
		
		else
			invaliderror();
		}
		
		output();
		
		//close the print writer
	    pw.close();
	    
	}

	public static void init() {
	//bringing in a dat file
	try {
		filescanner = new Scanner(new File("contributors.dat"));
		filescanner.useDelimiter(System.getProperty("line.separator"));
	} 
	//checking if its not being importing in 
	catch (FileNotFoundException e1) { 
		System.out.println("File error");
		System.exit(1);
	}

	try {
		pw = new PrintWriter(new File ("error.prt"));
	} catch (FileNotFoundException e) {
		System.out.println("Output file error");
	}
	
	//currency format
	nf = NumberFormat.getCurrencyInstance(java.util.Locale.US);
	
	//write column headings				
	pw.format("%-25s%5s%25s%5s%15s%5s%2s%5s%5s%5s%1s%5s%1s%5s%7s%n%n", "Contributor Name", " ", "Address", " ", 
															"City", " ", "State", " ", "Zip" , " " , "Party" , " " , "Gender" , " " , "Contribution");
	
	}
	

	
	public static void input() {
	String record;	//string used to hold entire record being read
	//as long as there are more records to be read
	if (filescanner.hasNext()) {
	  record = filescanner.next();
			iContributorName = record.substring(0,15);	
		    iAddress = record.substring(15,40);	
			iCity = record.substring(40,55);
			iState = record.substring(55,57);
			iZip = record.substring(57,62);		
			iParty = record.substring(62,63);	
			iGender = record.substring(63,64);
			iString3 = record.substring(64,74);
			iContribution = Double.parseDouble(iString3);
			
			}
	
	else {
		//checking for end of file
		eof=true;	
	     }	
		
		//validation for the contributor name
		try {
			if (iContributorName.trim().isEmpty()) {
				error = true;
				invalid = "Empty Name";
				}
			} 
		
		catch(Exception e) {
			    invalid = "Invalid Name";
			    error = true;
			}
		//validation for the address name
		try {
			if (iAddress.trim().isEmpty()) {
				error = true;
				invalid = "Empty Address";
			}
		}
		catch (Exception e) {
			invalid = "Invalid Address";
			error = true;
		}
		//validation for the city
		try {
			if (iCity.trim().isEmpty()) {
				error = true;
				invalid = "Empty City";
			}
		}
		catch (Exception e) {
			invalid = "Invalid City";
			error = true;
		}
		//validation for the state
		try {
			if (iState.trim().isEmpty()) {
				error = true;
				invalid = "Empty State";
			}
		}
		catch (Exception e) {
			invalid = "Invalid State";
			error = true;
		}
		//validation for the zip
		try {
			if (iZip.trim().isEmpty()) {
				error = true;
				invalid = "Empty Zip or length incorrect";
			}
		}
		catch (Exception e) {
			invalid = "Invalid Zip Code";
			error = true;
		}
		//validation for the party
		if (iParty.trim().isEmpty()) {
			error = true;
			invalid = "Party is empty";
		}
		//case structure for the party validation choices
		switch (iParty.toUpperCase()) {
		
			case "D":
				break;
			case "I":
				break;
			case "R":
				break;
			default:
				invalid = "Not a choice";
		}
		//validation for the gender
		if (iGender.trim().isEmpty()) {
			error = true;
			invalid = "Gender is Empty";
		}
		//validation for the gender choices
		switch (iGender) {
		
			case "M":
				break;
			case "F":
				break;
			default:
				invalid = "Not a choice for Gender";
		}
		//validation for the range of the contribution
		try {
			if (iContribution < .01 || iContribution > 9999.99) {
				invalid = "Contribution is out of range. Please be between .01 to 9999.99";
				error = true;
			}
		}
		catch (Exception e) {
			invalid = "Invalid contribution input";
			error = true;
		}
	}
	
	//error pw2 formats
	public static void invaliderror() {
		
		pw.format("%-20%5s%25s%5s%25s%5s%15s%5s%2s%5s%5s%5s%1s%5s%1s%5s%7s\n\n", invalid , " " , iContributorName , " ", iAddress , " ", 
				iCity, " ", iState, " ", iZip , " " , iParty , " ", iGender , " " , iContribution);
		}
	
	public static void calcs() {
		//if then statement to determine the calculation for the women and men.
		if (iGender.equals ("M")) {
			cmenctr = cmenctr + 1;
			coverall = coverall + 1;
			cmentotcon = cmentotcon + iContribution;
			coveralltotcon = coveralltotcon + iContribution;
			
			if (iParty.equals ("D")) {
				cdemoc = cdemoc + 1;
				cdemomen = cdemomen + 1;
				cdemototcon = cdemototcon + iContribution;
				cdemomentotcon = cdemomentotcon + iContribution;
				coveralltotcon = coveralltotcon + iContribution;
				}
			else {
				if (iParty.equals ("I")) {
					cind = cind + 1;
					cindmen = cindmen + 1;
					cindtotcon = cindtotcon + iContribution;
					cindmentotcon = cindmentotcon + iContribution;
					coveralltotcon = coveralltotcon + iContribution;
					
				}
				else {
					if (iParty.equals("R")) {
						crep = crep + 1;
						crepmen = crepmen + 1;
						creptotcon = creptotcon + iContribution; 
						crepmentotcon = crepmentotcon + iContribution;
						coveralltotcon = coveralltotcon + iContribution;
					}
				}
			}
		}
		//Women calculations
		else {
			cwomenctr = cwomenctr + 1;
			cwomentotcon = cwomentotcon + iContribution;
			coverall = coverall + 1;
			coveralltotcon = coveralltotcon + iContribution;
			
			if (iParty.equals ("D")) {
				cdemoc = cdemoc + 1;
				cdemowomen = cdemowomen + 1;
				cdemototcon = cdemototcon + iContribution;
				cdemowomentotcon = cdemowomentotcon + iContribution;
				coveralltotcon = coveralltotcon + iContribution;
			}
			else {
				if (iParty.equals("R")) {
					crep = crep + 1;
					crepwomen = crepwomen + 1;
					creptotcon = creptotcon + iContribution;
					crepwomentotcon = crepwomentotcon + iContribution;
					coveralltotcon = coveralltotcon + iContribution;
				}
				else {
					if (iParty.equals("I")) {
						cind = cind + 1;
						cindwomen = cindwomen + 1;
						cindtotcon = cindtotcon + iContribution;
						cindwomentotcon = cindwomentotcon + iContribution;
						coveralltotcon = coveralltotcon + iContribution;
						
					}
				}
			}
		}
		//END OF NESTED IF
		
		//these all are the lists of ifs that check the division of 0 so no crashing.
		if (cmenctr == 0) {
			cavgmen = 0;
		}
		else {
			cavgmen = cmentotcon/cmenctr;
		}
		if (cwomenctr == 0) {
			cavgwomen = 0;
		}
		else {
			cavgwomen = cwomentotcon/cwomenctr;
		}
		if (cdemomen == 0) {
			cavgdemomen = 0;
		}
		else {
			cavgdemomen = cdemomentotcon/cdemomen;
		}
		if (cdemowomen == 0) {
			cavgdemowomen = 0;
		}
		else {
			cavgdemowomen = cdemowomentotcon/cdemowomen;
		}
		if (cdemoc == 0) {
			cavgdemoc = 0;
		}
		else {
			cavgdemoc = cdemototcon/cdemoc;
		}
		if (crep == 0) {
			cavgrep = 0;
		}
		else {
			cavgrep = creptotcon/crep;
		}
		if (crepmen == 0) {
			cavgrepmen = 0;
		}
		else {
			cavgrepmen = crepmentotcon/crepmen;
		}
		if (crepwomen == 0) {
			cavgrepwomen = 0;
		}
		else {
			cavgrepwomen = crepwomentotcon/crepwomen;
		}
		if (cind == 0) {
			cavgind = 0;
		}
		else {
			cavgind = cindtotcon/cind;
		}
		if (cindmen == 0) {
			cavgindmen = 0;
		}
		else {
			cavgindmen = cindmentotcon/cindmen;
		}
		if (cindwomen == 0) {
			cavgindwomen = 0;
		}
		else {
			cavgindwomen = cindwomentotcon/cindwomen;
		}
		if (coverall == 0) {
			cavgoverall = 0;
		}
		else {
			cavgoverall = coveralltotcon/coverall;
		}
		//end of all the validation checking
}
		
	public static void output() {
		
		//format for the men
		omentotcon = nf.format(cmentotcon);
		oavgmen = nf.format(cavgmen);
		//format for the women
		owomentotcon = nf.format(cwomentotcon);
		oavgwomen = nf.format(cavgwomen);
		//format for the democrats as a whole
		odemototcon = nf.format(cdemototcon);
		oavgdemoc = nf.format(cavgdemoc);
		//format for the democrat men
		odemomentotcon = nf.format(cdemomentotcon);
		oavgdemomen = nf.format(cavgdemomen);
		//format for the democraft women
		odemowomentotcon = nf.format(cdemowomentotcon);
		oavgdemowomen = nf.format(cavgdemowomen);
		//format for the republicans
		oreptotcon = nf.format(creptotcon);
		oavgrep = nf.format(cavgrep);
		//format for the republicans men
		orepmentotcon = nf.format(crepmentotcon);
		oavgrepmen = nf.format(cavgrepmen);
		//format for the republicans women
		orepwomentotcon = nf.format(crepwomentotcon);
		oavgrepwomen = nf.format(cavgrepwomen);
		//format for the independents
		oindtotcon = nf.format(cindtotcon);
		oavgind = nf.format(cavgind);
		//format for the independent men
		oindmentotcon = nf.format(cindmentotcon);
		oavgindmen = nf.format(cavgindmen);
		//format for the independent women
		oindwomentotcon = nf.format(cindwomentotcon);
		oavgindwomen = nf.format(cavgindwomen);
		//format for the overall contributions and counters
		ooveralltotcon = nf.format(coveralltotcon);
		oavgoverall = nf.format(cavgoverall);
		//local time java importion code
		LocalTime time = LocalTime.now();
		//All print outs for the formats 
		System.out.format("%-6s%10s%10s%30s\n" , "DATE:" , java.time.LocalDate.now() , " " , "SAVE THE BARNS" );	
		System.out.format("%20s%20s%18s%20s\n" , " " , " " , "CONTRIBUTION COUNT" , " " );
		System.out.format("%20s%20s%20s%20s\n" , " " , " " , " " , " ", " ");
		System.out.format("%20s%20s%20s%20s\n" , " " , " " , " " , " ", " ");
		System.out.format("%-20s%15s%6s%15s%18s%8s%20s\n" , "PEOPLE" , " " , "COUNT" , " " , "TOTAL CONTRIBUTION" , " " , "AVERAGE CONTRIBUTION");
		System.out.format("%20s%20s%20s%20s\n" , " " , " " , " " , " ", " ");
		System.out.format("%-20s%-15s%6s%-15s%-11s%-15s%-10s\n" , "MEN" , " " , cmenctr , " " , omentotcon , " " , oavgmen);
		System.out.format("%-20s%-15s%6s%-15s%-11s%-15s%-10s\n" , "WOMEN" , " " , cwomenctr, " " , owomentotcon , " " , oavgwomen);
		System.out.format("%-20s%-15s%6s%-15s%-11s%-15s%-10s\n" , "DEMOCRATS" , " " , cdemoc , " " , odemototcon , " " , oavgdemoc);
		System.out.format("%-20s%-15s%6s%-15s%-11s%-15s%-10s\n" , "REPUBLICANS" , " " , crep , " " , oreptotcon, " " , oavgrep);
		System.out.format("%-20s%-15s%6s%-15s%-11s%-15s%-10s\n" , "INDEPENDENTS" , " " , cind , " " , oindtotcon , " " , oavgind);
		System.out.format("%-20s%-15s%6s%-15s%-11s%-15s%-10s\n" , "DEMOCRATIC MEN" , " " ,cdemomen , " " , odemomentotcon , " " , oavgdemomen);
		System.out.format("%-20s%-15s%6s%-15s%-11s%-15s%-10s\n" , "DEMOCRATIC WOMEN" , " " , cdemowomen , " " , odemowomentotcon , " " , oavgdemowomen);
		System.out.format("%-20s%-15s%6s%-15s%-11s%-15s%-10s\n" , "REPUBLICAN MEN" , " " , crepmen , " " , orepmentotcon , " " , oavgrepmen);
		System.out.format("%-20s%-15s%6s%-15s%-11s%-15s%-10s\n" , "REPUBLICAN WOMEN" , " " , crepwomen , " " , orepwomentotcon , " " , oavgrepwomen);
		System.out.format("%-20s%-15s%6s%-15s%-11s%-15s%-10s\n" , "INDEPENDENT MEN" , " " , cindmen , " " , oindmentotcon , " " , oavgindmen);
		System.out.format("%-20s%-15s%6s%-15s%-11s%-15s%-10s\n" , "OVERALL" , " " , coverall , " " , ooveralltotcon , " " , oavgoverall);
		}
}