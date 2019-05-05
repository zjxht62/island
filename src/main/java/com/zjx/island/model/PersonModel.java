package com.zjx.island.model;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/1/22
 */
public class PersonModel {
    String name;
    String id;
    String tel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public PersonModel(String name, String id, String tel) {
        this.name = name;
        this.id = id;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "PersonModel{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            ", tel='" + tel + '\'' +
            '}';
    }
}
