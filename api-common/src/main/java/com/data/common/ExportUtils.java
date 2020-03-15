package com.data.common;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jxcell.CellException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

/**
 * Cau hinh import file Excel.
 *
 * @author HuyenNV
 * @since 1.0
 * @version 1.0
 */
public class ExportUtils {

    public static final Logger LOGGER = LoggerFactory.getLogger(ExportUtils.class);
    public HashMap<Integer, CellBean> mapCellBean = new HashMap<Integer, CellBean>();
    private int numberOfColumns = 0;
    private int configRowNumber = 0;

    public ExportUtils(DynamicExport dynamicExport, int configRowNumber, int numberOfColumns)
            throws CellException {
        this.numberOfColumns = numberOfColumns;
        this.configRowNumber = configRowNumber;
        for (int col = 0; col < numberOfColumns; col++) {
            String content = dynamicExport.getCellText(configRowNumber, col);
            mapCellBean.put(col, new CellBean(col, content));
        }
    }

    /**
     * Doc cau hinh tu file.
     *
     * @param filePath Duong dan cua file
     * @return Mang cac thong tin cau hinh
     * @throws Exception Exception
     */
    public ExportUtils(String fileName, int sheetNum, int configRowNumber, int numberOfColumns)
            throws Exception {
        this.numberOfColumns = numberOfColumns;
        this.configRowNumber = configRowNumber;
        Sheet sheet = null;
        boolean outOfMemory = false;
        Workbook workbook = null;
        try {
            WorkbookSettings ws = new WorkbookSettings();
            ws.setEncoding("Cp1252"); // UTF-8
            ws.setCellValidationDisabled(true);
            File serverFile = new File(fileName);
            workbook = Workbook.getWorkbook(serverFile, ws);
            sheet = workbook.getSheet(sheetNum);
        } catch (OutOfMemoryError ex) {
            LOGGER.error("Loi doc file template", ex);
            outOfMemory = true;
        } catch (Exception ex) {
            LOGGER.error("Loi doc file template", ex);
        }
        if (sheet != null) {
            Cell[] cells = sheet.getRow(configRowNumber);
            for (int col = 0; col < numberOfColumns; col++) {
                if (col < cells.length) {
                    String content = cells[col].getContents();
                    mapCellBean.put(col, new CellBean(col, content));
                }
            }
            workbook.close();
        }
    }

    /**
     * xoa row config
     *
     * @param dynamicExport
     * @throws CellException
     */
    public void removeConfigRow(DynamicExport dynamicExport) throws CellException {
        for (int i = 0; i < numberOfColumns; i++) {
            dynamicExport.clearCell(configRowNumber, i);
        }
    }

    /**
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws CellException
     *
     */
    public <T> void exportRow(DynamicExport dynamicExport, T obj, int row)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException,
            CellException {
        for (int i = 0; i < this.numberOfColumns; i++) {
            CellBean bean = mapCellBean.get(i);
            if (!bean.isFormula() && !bean.isEmptyRow()) {
                Object value = PropertyUtils.getProperty(obj, bean.getProperty());
                bean.exportCell(dynamicExport, value, row);
            } else if (!bean.isEmptyRow()) {
                bean.exportCellFormular(dynamicExport, null, row, obj);
            } else {
                bean.exportCell(dynamicExport, null, row);
            }
        }
    }

    public class CellBean {

        private int columnIndex;
        private String property;
        private List<String> matchedProperty = new ArrayList<String>();
        private boolean isFormula = false;
        private boolean isEmptyRow = false;
        private String formula;
        private final String ROWNUM = "_ROWNUM";
        private final String COLNUM = "_COLNUM";

        /**
         * contructor
         */
        CellBean(int columnIndex, String data) {
            this.columnIndex = columnIndex;
            if (data != null && !"".equals(data.trim())) {
                data = data.trim();
                String prefix = "$";
                this.isFormula = !data.startsWith(prefix);
                if (this.isFormula) {
                    this.formula = data;
                    String pattern = "\\$\\{([a-zA-Z0-9_]+)\\}";
                    Pattern r = Pattern.compile(pattern);
                    Matcher m = r.matcher(this.formula);
                    while (m.find()) {
                        matchedProperty.add(trimParam(m.group()));
                    }
                } else {
                    this.property = data.substring(prefix.length(), data.length());
                }
            } else {
                this.isEmptyRow = true;
            }
        }

        /**
         * trim parameter formular
         *
         * @param param
         * @return
         */
        private String trimParam(String param) {
            return param.replace("${", "").replace("}", "");
        }

        /**
         * formatValue to formular
         *
         * @param value
         * @return
         */
        private String formatValue(Object value) {
            if (value == null) {
                return "";
            }
            if (value instanceof Double) {
                Double valueD = (Double) value;
                Double valueL = Double.valueOf(valueD.longValue());
                if (valueD.equals(valueL)) {
                    return String.valueOf(valueD.longValue());
                }
                return String.valueOf(valueD);
            } else {
                return String.valueOf(value);
            }
        }

        /**
         * exportCellFormular
         *
         * @param dynamicExport
         * @param value
         * @param row
         * @param obj
         * @throws CellException
         * @throws IllegalAccessException
         * @throws InvocationTargetException
         * @throws NoSuchMethodException employeeCode employeeName nationCode
         * startDate endDate positionNameEn deNameEN divNameEN soNameEN 30.00
         * dayOfPeriod rfl feriado subsidio attendance abcense
         * realWorkingDayTotal weekdayOvertime workingOnHoliday weekendOvertime
         * baseSalary baseBonus empKiTypeCode ki daySalary positionSalary bonus
         * empInsurance orgInsurance weekdaySalary nightShiftSalary bonusSales
         * fuelAllowance telephoneAllowance plus deduct preTaxRealSalary onaEmp
         * incomeTax tradeUnionFee revenue payment1st payment2nd accountNumber
         * bankBranch bankName email
         */
        public <T> void exportCellFormular(DynamicExport dynamicExport, Object value, int row, T obj)
                throws CellException, IllegalAccessException, InvocationTargetException,
                NoSuchMethodException {
            String formulas = this.formula.replace(ROWNUM, String.valueOf(row + 1));
            if (!matchedProperty.isEmpty()) {
                for (String propertyName : matchedProperty) {
                    Object valueProp = PropertyUtils.getProperty(obj, propertyName);
                    formulas = formulas.replace("${" + propertyName + "}", formatValue(valueProp));
                }
            }
            dynamicExport.setFormula(formulas, this.columnIndex, row);
            return;
        }

        /**
         * exportCell
         *
         * @param dynamicExport
         * @param value
         * @throws CellException
         */
        public void exportCell(DynamicExport dynamicExport, Object value, int row) throws CellException {
            if (this.isEmptyRow) {
                return;
            }
            if (value == null || "".equals(value)) {
                dynamicExport.setEntry("", this.columnIndex);
                return;
            }
            if (value instanceof String) {
                String valueStr = String.valueOf(value);
                dynamicExport.setText(valueStr, this.columnIndex, row);
            } else if (value instanceof Long) {
                Long valueLong = Long.valueOf(value.toString());
                dynamicExport.setEntry(CommonUtil.formatNumber(valueLong), this.columnIndex, row);
            } else if (value instanceof Double) {
                Double valueDouble = Double.valueOf(value.toString());
                dynamicExport.setEntry(CommonUtil.formatNumber(valueDouble), this.columnIndex, row);
            } else if (value instanceof Date) {
                Date valueDate = (Date) (value);
                dynamicExport.setText(CommonUtil.convertDateToString(valueDate), this.columnIndex, row);
            } else {
                LOGGER.warn("Khong xac dinh duoc kieu du lieu export");
                dynamicExport.setEntry("", this.columnIndex);
            }
        }

        /**
         * @return the columnIndex
         */
        public int getColumnIndex() {
            return columnIndex;
        }

        /**
         * @param columnIndex the columnIndex to set
         */
        public void setColumnIndex(int columnIndex) {
            this.columnIndex = columnIndex;
        }

        /**
         * @return the property
         */
        public String getProperty() {
            return property;
        }

        /**
         * @param property the property to set
         */
        public void setProperty(String property) {
            this.property = property;
        }

        /**
         * @return the isFormula
         */
        public boolean isFormula() {
            return isFormula;
        }

        /**
         * @param isFormula the isFormula to set
         */
        public void setFormula(boolean isFormula) {
            this.isFormula = isFormula;
        }

        /**
         * @return the isEmptyRow
         */
        public boolean isEmptyRow() {
            return isEmptyRow;
        }

        /**
         * @param isEmptyRow the isEmptyRow to set
         */
        public void setEmptyRow(boolean isEmptyRow) {
            this.isEmptyRow = isEmptyRow;
        }

        /**
         * @return the formula
         */
        public String getFormula() {
            return formula;
        }

        /**
         * @param formula the formula to set
         */
        public void setFormula(String formula) {
            this.formula = formula;
        }
    }
}
