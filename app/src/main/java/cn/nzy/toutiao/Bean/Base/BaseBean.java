package cn.nzy.toutiao.Bean.Base;

public class BaseBean<T> {

    private int count;
    private int err;
    public T items;

    public T getItems() {
        return items;
    }

    public void setItems(T items) {
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
    }

}
