package com.lft.java8.excel.read.merge;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellExtra;
import com.google.common.base.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * 描述
 * @author Ryze
 * @date 2020-04-16 15:44
 */
public class ADataListener extends AnalysisEventListener<A> {
    private List<A> list = new ArrayList<>();

    @Override
    public void invoke(A data, AnalysisContext context) {
        list.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        list.stream().forEach(System.out::println);
    }

    @Override
    public void extra(CellExtra extra, AnalysisContext context) {
        Integer firstColumnIndex = extra.getFirstColumnIndex() + 1;
        Integer lastColumnIndex = extra.getLastColumnIndex() + 1;
        Integer firstRowIndex = extra.getFirstRowIndex() - 1;
        Integer lastRowIndex = extra.getLastRowIndex() - 1;
        A a = list.get(firstRowIndex);
        Function<A, String> aStringFunction = swatchRow1(firstColumnIndex);
        String value = aStringFunction.apply(a);
        for (int i = firstRowIndex ; i <= lastRowIndex; i++) {
            for (int j = firstColumnIndex ; j <= lastColumnIndex; j++) {
                A a1 = list.get(i);
                BiConsumer<A, String> aStringBiConsumer = swatchRow(j);
                aStringBiConsumer.accept(a1,value);
            }
        }
    }

    private BiConsumer<A, String> swatchRow(Integer integer) {
        switch (integer) {
            case 1:
                return A::setRow1;
            case 2:
                return A::setRow2;
            case 3:
                return A::setRow3;
            case 4:
                return A::setRow4;
            case 5:
                return A::setRow5;
            case 6:
                return A::setRow6;
        }
        return null;
    }

    private Function<A, String> swatchRow1(Integer integer) {
        switch (integer) {
            case 1:
                return A::getRow1;
            case 2:
                return A::getRow2;
            case 3:
                return A::getRow3;
            case 4:
                return A::getRow4;
            case 5:
                return A::getRow5;
            case 6:
                return A::getRow6;
        }
        return null;
    }

}
