package javacontribute.javaspringboot.entity;

/**
 * @author: Lijie
 * @Date: 2018/12/25 10:27
 */
public class FilterEntity {
    private int id;
    private String phoneNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "FilterEntity{" +
                "id=" + id +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
