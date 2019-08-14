package com.lft.java8.create;

import java.io.*;

/**
 * 描述
 * @author Ryze
 * @date 2019-08-13 20:42
 */
public class TestEnum {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\set.obj"))) {
            oos.writeObject(AEnum.A1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(AEnum.A1);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\set.obj"))) {
            AEnum aEnum = (AEnum) ois.readObject();
            System.out.println(aEnum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
