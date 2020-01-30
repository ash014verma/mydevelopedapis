package za.co.discovery.assignment.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;


@Service("excelPOIHelper")
public class ExcelPOIHelper {

	public  Map<Integer, Map<Integer, List<MyCell>>> readExcel(String fileLocation) throws IOException {
		Map<Integer, Map<Integer, List<MyCell>>> data = new LinkedHashMap<>();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(fileLocation));

			if (fileLocation.endsWith(".xls")) {
				data = readHSSFWorkbook(fis);
			} else if (fileLocation.endsWith(".xlsx")) {
				data = readXSSFWorkbook(fis);
			}
		}finally {
			if(fis!= null) {
				fis.close();
			}
		}
		return data;
	}

	private  String readCellContent(Cell cell) {
		String content;
		switch (cell.getCellType()) {
		case STRING:
			content = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				content = cell.getDateCellValue() + "";
			} else {
				content = cell.getNumericCellValue() + "";
			}
			break;
		case BOOLEAN:
			content = cell.getBooleanCellValue() + "";
			break;
		case FORMULA:
			content = cell.getCellFormula() + "";
			break;
		default:
			content = "";
		}
		return content;
	}

	private  Map<Integer, Map<Integer, List<MyCell>>> readHSSFWorkbook(FileInputStream fis) throws IOException {
		Map<Integer, Map<Integer, List<MyCell>>> dataMap = new LinkedHashMap<>();
		Map<Integer, List<MyCell>> data = new LinkedHashMap<>();
		HSSFWorkbook workbook = null;
		try {
			workbook = new HSSFWorkbook(fis);
			for (int k = 0; k < workbook.getNumberOfSheets(); k++)
			{
				HSSFSheet sheet = workbook.getSheetAt(k);
				dataMap.put(k, data);
				for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
					HSSFRow row = sheet.getRow(i);
					data.put(i, new ArrayList<>());
					if (row != null) {
						for (int j = 0; j < row.getLastCellNum(); j++) {
							HSSFCell cell = row.getCell(j);
							if (cell != null) {
								HSSFCellStyle cellStyle = cell.getCellStyle();

								MyCell myCell = new MyCell();

								myCell.setContent(readCellContent(cell));
								data.get(i)
								.add(myCell);
							} else {
								data.get(i)
								.add(new MyCell(""));
							}
						}
					}
				}
			}
		} finally {
			if (workbook != null) {
				workbook.close();
			}
		}
		return dataMap;
	}

	private  Map<Integer, Map<Integer, List<MyCell>>> readXSSFWorkbook(FileInputStream fis) throws IOException {
		XSSFWorkbook workbook = null;
		Map<Integer, Map<Integer, List<MyCell>>> dataMap = new LinkedHashMap<>();
		Map<Integer, List<MyCell>> data = null;

		try {

			workbook = new XSSFWorkbook(fis);
			for (int k = 0; k < workbook.getNumberOfSheets(); k++)
			{
				XSSFSheet sheet = workbook.getSheetAt(k);
				data = new LinkedHashMap<>();
				for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {


					XSSFRow row = sheet.getRow(i);
					data.put(i, new ArrayList<>());
					if (row != null) {
						for (int j = 0; j < row.getLastCellNum(); j++) {
							XSSFCell cell = row.getCell(j);
							if (cell != null) {
								XSSFCellStyle cellStyle = cell.getCellStyle();
								MyCell myCell = new MyCell();
								myCell.setContent(readCellContent(cell));
								data.get(i)
								.add(myCell);
							} else {
								data.get(i)
								.add(new MyCell(""));
							}
						}
					}
				}
				dataMap.put(k, data);
			}
		} finally {
			if (workbook != null) {
				workbook.close();
			}
		}
		return dataMap;
	}

}