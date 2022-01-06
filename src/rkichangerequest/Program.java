package rkichangerequest;

public class Program {

	public static void main(String[] args) {
		try {
			String filePath = "D:\\RKI ChangeRequest\\Fallzahlen_Gesamtuebersicht.csv";
			String[][] csvFile = CsvFile.readCsvFile(filePath);
			
			PrettySmlOutput output = new PrettySmlOutput("Tabelle", "Ende");
			output.beginElement("Metadaten");
			
			Table metaTable = new Table();
			metaTable.addLine("Beschreibung", "COVID-19 Fallzahlen und Todesfälle mit Differenz zum Vortag sowie Fall-Verstorbenen-Anteil nach Berichtstag");
			metaTable.addLine("Stand", csvFile[csvFile.length-1][0]);
			metaTable.addLine("Quelle", "https://www.rki.de/DE/Content/InfAZ/N/Neuartiges_Coronavirus/Daten/Fallzahlen_Gesamtuebersicht.html");
			
			output.writeTable(metaTable.toArray(), false);
			
			output.beginElement("Spalten");
			
			Table columnsTable = new Table();
			columnsTable.addLine("Bd", "Berichtsdatum");
			columnsTable.addLine("FGes", "Anzahl COVID-19-Fälle");
			columnsTable.addLine("FDiff", "Differenz Vortag Fälle");
			columnsTable.addLine("TfGes", "Todesfälle");
			columnsTable.addLine("TfDiff", "Differenz Vortag Todesfälle");
			columnsTable.addLine("TfGes/FGes", "Fall-Verstorbenen-Anteil");
			columnsTable.addLine("FGes-TfGes", "Fälle ohne Todesfälle");
			output.writeTable(columnsTable.toArray(), false);
			
			output.closeElement();
			
			output.closeElement();
			output.beginElement("Daten");
			
			Table table = new Table();
			table.addLine("Bd", "FGes", "FDiff", "TfGes", "TfDiff", "TfGes/FGes", "FGes-TfGes");
			for (int i=3; i<csvFile.length; i++) {
				String[] line = csvFile[i];
				table.addLine(line);
			}
			output.writeTable(table.toArray(), true);
			
			output.closeElement();
			output.finish();
			output.save("D:\\RKI ChangeRequest\\Fallzahlen_Gesamtuebersicht.sml");
		} catch(Exception e) {
			System.out.println("[ERROR] "+e.getMessage());
		}
	}
	
}
