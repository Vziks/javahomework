package info.vziks.homework4;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework1.Task11Command;
import info.vziks.homework4.animals.Dog;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class Task43CommandTest {
    @Test
    public void testTask43Command() throws TaskCommandException {
        String check = "Dog{name='sknbepeknt', weight=18, age=18, color='null', address='null'}\n" +
                "Dog{name='bouftonenk', weight=14, age=3, color='cauqlzfmta', address='null'}\n" +
                "Dog{name='kuhletwlsb', weight=16, age=16, color='nptqxedizs', address='null'}\n" +
                "Dog{name='pwlrxvflbl', weight=24, age=9, color='ptxgiuorzn', address='dpiihjtfzq'}\n" +
                "Dog{name='yoylgpaeqg', weight=11, age=19, color='null', address='null'}\n" +
                "Dog{name='cjcxkjtizz', weight=28, age=7, color='nkfpcmzaku', address='vuplfxfsvy'}\n" +
                "Dog{name='yyftjslsac', weight=10, age=25, color='zrqkynntfl', address='ohmmfhhxrs'}\n" +
                "Dog{name='favursvccm', weight=3, age=28, color='jbtoxwmirw', address='zzkpzesbhk'}\n" +
                "Dog{name='gsehdhwpwr', weight=13, age=3, color='null', address='null'}\n" +
                "Dog{name='avjbehbfxr', weight=6, age=26, color='null', address='null'}\n" +
                "Dog{name='ebwbcxwqyq', weight=4, age=6, color='null', address='null'}\n" +
                "Dog{name='sqxigwpaqr', weight=21, age=6, color='lwaqplrqoy', address='null'}\n" +
                "Dog{name='vgusxldteu', weight=4, age=5, color='lgrztpcnxl', address='lpgbxwlost'}\n" +
                "Dog{name='spgbxeigar', weight=17, age=16, color='uqurcqwklt', address='null'}\n" +
                "Dog{name='ivezlbzoqm', weight=10, age=22, color='null', address='null'}\n" +
                "Dog{name='hkegujagtu', weight=22, age=6, color='null', address='null'}\n" +
                "Dog{name='cmfgwybxdt', weight=26, age=1, color='null', address='null'}\n" +
                "Dog{name='blnhoeivsz', weight=20, age=20, color='nnuocmubou', address='null'}\n" +
                "Dog{name='oukqctjffs', weight=10, age=26, color='null', address='null'}\n" +
                "Dog{name='wowfkwcngv', weight=14, age=27, color='null', address='uidubxmdsm'}\n";

        Task43Command classTask43CommandTest = new Task43Command();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        classTask43CommandTest.execute();

        assertEquals(check, outContent.toString());
    }


    @Test(expected = TaskCommandException.class)
    public void testTask43CommandRandomExeptionExpected1() throws TaskCommandException {
        new Dog("TaskCommandException", 10, 0);
    }

    @Test(expected = TaskCommandException.class)
    public void testTask43CommandRandomExeptionExpected2() throws TaskCommandException {
        new Dog("TaskCommandException", 0, 10);
    }

}
