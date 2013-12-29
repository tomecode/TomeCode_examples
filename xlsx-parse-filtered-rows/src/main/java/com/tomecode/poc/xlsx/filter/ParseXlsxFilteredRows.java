package com.tomecode.poc.xlsx.filter;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow;

/**
 *
 * Print filtered rows from MS Excel file(*.xlsx) with Apache POI API
 *
 * @author Tomecode.com
 * 
 */
public final class ParseXlsxFilteredRows {

	public static void main(String[]arg) throws Exception {

		XSSFWorkbook workbook = null;
		workbook = new XSSFWorkbook(OPCPackage.open(ParseXlsxFilteredRows.class.getResourceAsStream("ExcelFile.xlsx")));
		XSSFSheet xssfSheet = workbook.getSheetAt(0);

		List<Integer> filteredRows = new ArrayList<Integer>();
		for (CTRow row : xssfSheet.getCTWorksheet().getSheetData().getRowList()) {
			if (!row.isSetHidden()) {
				int rowNum = (int) row.getR() - 1;
				if (rowNum != 0) {
					filteredRows.add(rowNum);
				}
			}
		}

		for (int rowNum : filteredRows) {
			System.out.println(xssfSheet.getRow(rowNum).getCell(0).getStringCellValue());
		}

	}

}
