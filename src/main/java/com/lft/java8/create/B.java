package com.lft.java8.create;

/**
 * 描述
 * @author Ryze
 * @date 2019-08-12 13:53
 */
public class B {
    private String b1;
    private String b2;
    private String b3;
    private String b4;
    private String b5;
    private String b6;
    private String b7;
    private String b8;
    private String b9;
    private String b10;

    public B() {
    }

    public B(B b) {
        this.b1 = b.getB1();
        this.b2 = b.getB2();
        this.b3 = b.getB3();
        this.b4 = b.getB4();
        this.b5 = b.getB5();
        this.b6 = b.getB6();
        this.b7 = b.getB7();
        this.b8 = b.getB8();
        this.b9 = b.getB9();
        this.b10 = b.getB10();
    }

    public String getB1() {
        return this.b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    public String getB2() {
        return this.b2;
    }

    public void setB2(String b2) {
        this.b2 = b2;
    }

    public String getB3() {
        return this.b3;
    }

    public void setB3(String b3) {
        this.b3 = b3;
    }

    public String getB4() {
        return this.b4;
    }

    public void setB4(String b4) {
        this.b4 = b4;
    }

    public String getB5() {
        return this.b5;
    }

    public void setB5(String b5) {
        this.b5 = b5;
    }

    public String getB6() {
        return this.b6;
    }

    public void setB6(String b6) {
        this.b6 = b6;
    }

    public String getB7() {
        return this.b7;
    }

    public void setB7(String b7) {
        this.b7 = b7;
    }

    public String getB8() {
        return this.b8;
    }

    public void setB8(String b8) {
        this.b8 = b8;
    }

    public String getB9() {
        return this.b9;
    }

    public void setB9(String b9) {
        this.b9 = b9;
    }

    public String getB10() {
        return this.b10;
    }

    public void setB10(String b10) {
        this.b10 = b10;
    }

    public static class BBuilder {
        private B b;

        public BBuilder() {
            this.b = new B();
        }

        public BBuilder b1(String b1) {
            this.b.setB1(b1);
            return this;
        }

        public BBuilder b2(String b2) {
            this.b.setB2(b2);
            return this;
        }

        public BBuilder b3(String b3) {
            this.b.setB3(b3);
            return this;
        }

        public BBuilder b4(String b4) {
            this.b.setB4(b4);
            return this;
        }

        public BBuilder b5(String b5) {
            this.b.setB5(b5);
            return this;
        }

        public BBuilder b6(String b6) {
            this.b.setB6(b6);
            return this;
        }

        public BBuilder b7(String b7) {
            this.b.setB7(b7);
            return this;
        }

        public BBuilder b8(String b8) {
            this.b.setB8(b8);
            return this;
        }

        public BBuilder b9(String b9) {
            this.b.setB9(b9);
            return this;
        }

        public BBuilder b10(String b10) {
            this.b.setB10(b10);
            return this;
        }

        public B build() {
            return new B(this.b);
        }
    }
}
