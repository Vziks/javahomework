package info.vziks.homework14;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework14.Stream.AppSteam;
import info.vziks.utils.Command;

import java.io.*;


public class Task141Command implements Command {
    @Override
    public void execute() throws TaskCommandException {
        try {
            AppSteam.write(AppSteam.getFile(), false);
            System.out.println(AppSteam.read(AppSteam.getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
