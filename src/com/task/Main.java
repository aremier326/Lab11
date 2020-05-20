package com.task;

import com.task.employee.Employee;
import com.task.manager.Manager;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /**
         * Reading employees and manager from files.
         */
        Manager manager1 = null;
        Employee employee1 = null;
        Employee employee2 = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\Atem Johnson\\IdeaProjects\\Lab11\\InputManager.txt"));

            manager1 = new Manager(Integer.parseInt(reader.readLine()), reader.readLine(),
                    reader.readLine(), Double.parseDouble(reader.readLine()));

            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\Atem Johnson\\IdeaProjects\\Lab11\\InputEmployees.txt"));

            employee1 = new Employee(Integer.parseInt(reader.readLine()), reader.readLine(),
                    reader.readLine(), Double.parseDouble(reader.readLine()), manager1);

            employee2 = new Employee(Integer.parseInt(reader.readLine()), reader.readLine(),
                    reader.readLine(), Double.parseDouble(reader.readLine()), manager1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                reader.close();
        }

        /**
         * Creating FileOutputStream object for writing to the specified file.
         */
        FileOutputStream fileOut = null;
        /**
         * Creating ObjectOutputStream object for writing to the specified OutputStream.
         */
        ObjectOutputStream out;

        /**
         * Creating FileInputStream object for reading from the specified file.
         */
        FileInputStream fileIn = null;
        /**
         * Creating ObjectInputStream object for reading to the specified InputStream.
         */
        ObjectInputStream in;

        try {
            fileOut = new FileOutputStream("SerializedEmployee");
            out = new ObjectOutputStream(fileOut);


            out.writeObject(employee1);
            out.writeObject(employee2);

            fileOut = new FileOutputStream("SerializedManager");
            out = new ObjectOutputStream(fileOut);
            out.writeObject(manager1);

            fileIn = new FileInputStream("SerializedEmployee");
            in = new ObjectInputStream(fileIn);
            Employee serializedEmployee1 = (Employee) in.readObject();
            Employee serializedEmployee2 = (Employee) in.readObject();

            fileIn = new FileInputStream("SerializedManager");
            in = new ObjectInputStream(fileIn);
            Manager serializedManager1 = (Manager) in.readObject();

            System.out.println(serializedEmployee1);
            System.out.println(serializedEmployee2);

            System.out.println(serializedManager1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            fileIn.close();
            fileOut.close();
        }

    }
}
