package com.interview.fpt.models;

import java.util.Objects;

public class HelloWorld {

    public String test;

    public HelloWorld(String test){
        this.test = test;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HelloWorld that = (HelloWorld) o;
        return test.equals(that.test);
    }

    @Override
    public int hashCode() {
        return Objects.hash(test);
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "test='" + test + '\'' +
                '}';
    }
}
