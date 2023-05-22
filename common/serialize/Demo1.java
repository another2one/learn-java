package common.serialize;

import util.Define;
import util.FileHelper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/*
    练习：
        1. 将存有多个Student对象的集合序列化操作，保存到list.txt 文件中。
        2. 反序列化list.txt ，并遍历集合，打印对象信息。

    步骤：
        1. 创建集合，用来保存Student
        2. 向集合中添加Student对象。
        3. 创建ObjectOutputStream序列化流，用来写。
        4. 调用writeObject方法，向文件中写集合对象。
        5. 释放资源。
        6. 创建ObjectInputStream反序列化流对象，用来读取
        7. 调用readObject方法，从文件中读取对象。
        8. 将读取到的集合进行遍历，并输出结果。

    注意：如果想要将多个对象保存在文件中，最好的一个方式可以将多个对象放入到一个集合中，然后直接将集合写到文件中。
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("lizhi", 0));
        studentArrayList.add(new Student("lizhi1", 1));
        studentArrayList.add(new Student("lizhi2", 2));

        String filename = Define.APP_PATH + "common\\serialize\\data\\student.ser";
        if (!FileHelper.checkFile(filename)) {
            System.out.printf("create file error \n");
            return;
        }
        Path serFile = Paths.get(filename);

        // 序列化
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(serFile))) {
            out.writeObject(studentArrayList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // 反序列化
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(serFile))) {
            studentArrayList = (ArrayList<Student>) in.readObject();
            for (Student stu : studentArrayList) {
                stu.print();
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}

class Student implements Serializable {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void print() {
        System.out.printf("Student info: \n name = %s\n age = %d \n", name, age);
    }
}
