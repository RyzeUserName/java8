package com.lft.java8.io;

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.*;

import java.util.List;

/**
 * 描述
 * @author Ryze
 * @date 2020-01-02 15:57
 */
public class ColorCell implements CellWriteHandler {
//    @Override
//    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, int relativeRowIndex, boolean isHead) {
////        // row
////        System.out.printf("第%s行", row.getRowNum());
////        Workbook workbook = writeSheetHolder.getSheet().getWorkbook();
////        CellStyle cellStyle = workbook.createCellStyle();
////        cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
////        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
////        row.setRowStyle(cellStyle);
//    }
//
//    @Override
//    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, CellData cellData, org.apache.poi.ss.usermodel.Cell cell, Head head, int relativeRowIndex, boolean isHead) {
//        // 这里可以对cell进行任何操作
//        System.out.printf("第%s行，第%s列写入完成。", cell.getRowIndex(), cell.getColumnIndex());
//        Workbook workbook = writeSheetHolder.getSheet().getWorkbook();
//        CellStyle cellStyle = workbook.createCellStyle();
//        cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
//        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        cell.setCellStyle(cellStyle);
//    }

    /**
     * Called before create the cell
     *  @param writeSheetHolder
     * @param writeTableHolder
     *            Nullable.It is null without using table writes.
     * @param row
     * @param head
     *            Nullable.It is null in the case of fill data and without head.
     * @param columnIndex
     * @param relativeRowIndex
     *            Nullable.It is null in the case of fill data.
     * @param isHead
     */
    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, Integer columnIndex, Integer relativeRowIndex, Boolean isHead) {

    }

    /**
     * Called after the cell is created
     *  @param writeSheetHolder
     * @param writeTableHolder
     *            Nullable.It is null without using table writes.
     * @param cell
     * @param head
     *            Nullable.It is null in the case of fill data and without head.
     * @param relativeRowIndex
     *            Nullable.It is null in the case of fill data.
     * @param isHead
     */
    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {

    }

    /**
     * Called after the cell data is converted
     *  @param writeSheetHolder
     * @param writeTableHolder
     *            Nullable.It is null without using table writes.
     * @param cellData
     *            Nullable.It is null in the case of add header.
     * @param cell
     * @param head
     *            Nullable.It is null in the case of fill data and without head.
     * @param relativeRowIndex
     *            Nullable.It is null in the case of fill data.
     * @param isHead
     */
    @Override
    public void afterCellDataConverted(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, CellData cellData, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {

    }

    /**
     * Called after all operations on the cell have been completed
     *  @param writeSheetHolder
     * @param writeTableHolder
     *            Nullable.It is null without using table writes.
     * @param cellDataList
     *            Nullable.It is null in the case of add header.There may be several when fill the data.
     * @param cell
     * @param head
     *            Nullable.It is null in the case of fill data and without head.
     * @param relativeRowIndex
     *            Nullable.It is null in the case of fill data.
     * @param isHead
     */
    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<CellData> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {

    }
}
