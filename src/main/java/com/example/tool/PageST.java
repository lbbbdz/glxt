package com.example.tool;

import lombok.Data;
import org.apache.ibatis.annotations.Param;

@Data
public class PageST {

    public int PageNum;
    public int PageSize;
    public String BookName;

    public PageST(int pageNum, int pageSize, String bookName) {
        PageNum = pageNum;
        PageSize = pageSize;
        BookName = bookName;
    }

    public int getPageNum() {
        return PageNum;
    }

    public void setPageNum(int pageNum) {
        PageNum = pageNum;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    @Override
    public String toString() {
        return "PageST{" +
                "PageNum=" + PageNum +
                ", PageSize=" + PageSize +
                ", BookName='" + BookName + '\'' +
                '}';
    }
}
