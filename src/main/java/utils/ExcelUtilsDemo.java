package utils;

public class ExcelUtilsDemo {

    public static void main(String[] args) {


        ExcelUtils excel = new ExcelUtils("src/main/java/excel/data.xlsx", "Arkusz1");

        excel.getRowCount();
        excel.getCellDataString(0, 0);
        excel.getCellDataNumber(1,1);


    }
}
