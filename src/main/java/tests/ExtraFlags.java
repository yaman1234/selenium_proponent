package tests;

import utilities.ExcelRead;

public class ExtraFlags {

//	Define the array of keywords

	static String[] report = { "chem and phys", "phys/chem", "physical and chemical", "physical/chemical",
			"chem & phys", "CHEM&PHYS", "CHEM ,  PHYS", "chemical , physical", "chemical physical", "phys , chem" };
	static String[] dom = { "date of manufacturing", "date of manufacturer", "date of manufacture", "manufacuring date",
			"mfr. date", "mfr date", "date of mfg", "mfr date", "date of mfr", "cure date","cure dates", "date of mfg", "mfg date",
			" dom ", "dom," };
	static String[] dfar = { "dfars compliance", "dfar compliance", "dfar compliant", "dfars compliant", "dfar" };

	public static void main(String[] args) {
		Boolean dfarCheck;
		Boolean reportCheck;
		Boolean domCheck;

//		Read from the TestData Excel
		int rowCount = ExcelRead.getRowCount("extraFlags");
		System.out.println(rowCount);

		for (int i = 1; i <= rowCount; i++) {
			String caseNumber = ExcelRead.getData(i, 2, "extraFlags");
			String description = ExcelRead.getData(i, 1, "extraFlags").toLowerCase();

			dfarCheck = false;
			reportCheck = false;
			domCheck = false;

//			check for dfar
			for (int j = 0; j < dfar.length; j++) {
				if (description.contains(dfar[j].toLowerCase())) {
					dfarCheck = true;
					break;
				}
			}
//			check for the report
			for (int j = 0; j < report.length; j++) {
				if (description.contains(report[j].toLowerCase())) {
					reportCheck = true;
					break;
				}
			}

//			check for the dom
			for (int j = 0; j < dom.length; j++) {
				if (description.contains(dom[j].toLowerCase())) {
					domCheck = true;
					break;
				}
			}
			
//			write to Excel File
			ExcelRead.writeData(i, 6, "extraFlags", dfarCheck.toString());
			ExcelRead.writeData(i, 7, "extraFlags", reportCheck.toString());
			ExcelRead.writeData(i, 8, "extraFlags", domCheck.toString());

			System.out.println(i + ", " +caseNumber + ", " + dfarCheck + " " + reportCheck + " " + domCheck);
		}

	}

}
