package com.lft.java8.io;

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.*;

/**
 * 描述
 * @author Ryze
 * @date 2020-01-02 15:57
 */
public class ColorCell implements CellWriteHandler {
    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, int relativeRowIndex, boolean isHead) {
//        // row
//        System.out.printf("第%s行", row.getRowNum());
//        Workbook workbook = writeSheetHolder.getSheet().getWorkbook();
//        CellStyle cellStyle = workbook.createCellStyle();
//        cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
//        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        row.setRowStyle(cellStyle);
    }

    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, CellData cellData, org.apache.poi.ss.usermodel.Cell cell, Head head, int relativeRowIndex, boolean isHead) {
        // 这里可以对cell进行任何操作
        System.out.printf("第%s行，第%s列写入完成。", cell.getRowIndex(), cell.getColumnIndex());
        Workbook workbook = writeSheetHolder.getSheet().getWorkbook();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(cellStyle);
    }
}
