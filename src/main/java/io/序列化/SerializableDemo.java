package io.序列化;

import java.io.*;

public class SerializableDemo {
    private static class A implements Serializable {

        private String username;
        private transient String password;

        A(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public String toString() {
            return "A{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A a1 = new A("cky", "123");
        String path = "F:\\a1";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(a1);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        A a2 = (A) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(a2);
    }
}
