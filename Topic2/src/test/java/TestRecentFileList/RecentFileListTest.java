/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestRecentFileList;

import RecentFileList.RecentFileList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Adrian
 */
public class RecentFileListTest {

    RecentFileList recentFileList = new RecentFileList();

    @Before
    public void setUp() {

        recentFileList.addFile("File1");
        recentFileList.addFile("File2");
        recentFileList.addFile("File3");
        recentFileList.addFile("File4");
        recentFileList.addFile("File5");
        recentFileList.addFile("File6");
        recentFileList.addFile("File7");
        recentFileList.addFile("File8");
        recentFileList.addFile("File9");
        recentFileList.addFile("File10");
        recentFileList.addFile("File11");
        recentFileList.addFile("File12");
        recentFileList.addFile("File13");
        recentFileList.addFile("File14");
        recentFileList.addFile("File15 - Primero en mostrar");
    }

    @Test
    public void testListEmpty() {

        assertFalse(recentFileList.listEmpty());
    }

    @Test
    public void testAddFile() {

        recentFileList.addFile("FileX");
        assertEquals("FileX", recentFileList.getRecentFileList().get(0));
    }

    @Test
    public void testAddFileToFullList() {

        recentFileList.addFile("FileX");

        assertEquals("FileX", recentFileList.getRecentFileList().get(0));
        assertEquals("File2", recentFileList.getRecentFileList().get(14));
    }

    @Test
    public void testAddExistingFile() {

        recentFileList.addFile("File2");
        assertNotEquals("File2", recentFileList.getRecentFileList().get(13));
        assertEquals("File2", recentFileList.getRecentFileList().get(0));
    }

    @Test
    public void testFileExists() {

        assertTrue(recentFileList.fileExists("File10"));
    }

    @Test
    public void testListFull() {

        assertTrue(recentFileList.listFull());
    }

}
