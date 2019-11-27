package info.vziks.exam.serialization;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        File file = new File("launch.out");
        Launch launch = new Launch();
        if (!file.exists()) {
            launch.update();
        } else {

            try (ObjectInputStream objectOutputStream = new ObjectInputStream(
                    new FileInputStream(file))) {
                launch = (Launch) objectOutputStream.readObject();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }

        }
        launch.update();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(file))) {
            objectOutputStream.writeObject(launch);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(launch);

        File file1 = new File("launch1.out");
        LauchExternalizable lauchExternalizable = new LauchExternalizable();
        if (!file1.exists()) {
            lauchExternalizable.update();
        } else {

            try (ObjectInputStream objectOutputStream = new ObjectInputStream(
                    new FileInputStream(file1))) {
                lauchExternalizable = (LauchExternalizable) objectOutputStream.readObject();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }

        }
        lauchExternalizable.update();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(file1))) {
            objectOutputStream.writeObject(lauchExternalizable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(lauchExternalizable);
    }
}
