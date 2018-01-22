package com.example.dome.entity.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2018/1/9.
 */
public class TListCount<T extends List> implements Serializable {

    private int count;
    private T list;

    public TListCount(int count, T list) {
        this.count = count;
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TListCount<?> that = (TListCount<?>) o;

        if (count != that.count) return false;
        return list != null ? list.equals(that.list) : that.list == null;
    }

    @Override
    public int hashCode() {
        int result = count;
        result = 31 * result + (list != null ? list.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TListCount{" +
                "count=" + count +
                ", list=" + list +
                '}';
    }
}
