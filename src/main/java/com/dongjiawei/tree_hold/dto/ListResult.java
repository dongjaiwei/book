package com.dongjiawei.tree_hold.dto;

import java.util.List;

public class ListResult<D> {

    int totalSize;
    List<D> dataList;

    public ListResult() {
    }

    public ListResult(int totalSize, List<D> dataList) {
        this.totalSize = totalSize;
        this.dataList = dataList;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public List<D> getDataList() {
        return dataList;
    }

    public void setDataList(List<D> dataList) {
        this.dataList = dataList;
    }

}
