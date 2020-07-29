package com.whz.javaee.spring.ioc;

public class Source {
    private String fruit;
    private String sugar;
    private String size;

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Source{");
        sb.append("fruit='").append(fruit).append('\'');
        sb.append(", sugar='").append(sugar).append('\'');
        sb.append(", size='").append(size).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
