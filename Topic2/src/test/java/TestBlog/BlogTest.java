/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestBlog;

import Blogg.Blog;
import Blogg.Entry;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


/**
 *
 * @author Adrian
 */
public class BlogTest {

    public Blog blog;

    @Before
    public void setUp() {

        blog = new Blog();
        blog.postNewEntry(new Entry("E1", "AEW", "asd"));
        blog.postNewEntry(new Entry("E2", "AEW", "asd"));
        blog.postNewEntry(new Entry("E3", "AEW", "asd"));
        blog.postNewEntry(new Entry("E4", "AEW", "asd"));
        blog.postNewEntry(new Entry("E5", "AEW", "asd"));
        blog.postNewEntry(new Entry("E6", "AEW", "asd"));
        blog.postNewEntry(new Entry("E7", "AEW", "asd"));
        blog.postNewEntry(new Entry("E8", "AEW", "asd"));
        blog.postNewEntry(new Entry("E9", "AEW", "asd"));
        blog.postNewEntry(new Entry("E9", "AEW", "asd"));
        blog.postNewEntry(new Entry("E10", "AEW", "asd"));
        blog.postNewEntry(new Entry("E11", "AEW", "asd"));
        blog.postNewEntry(new Entry("E12", "AEW", "asd"));
        blog.postNewEntry(new Entry("E13", "AEW", "asd"));
        blog.postNewEntry(new Entry("E14", "AEW", "asd"));
        blog.postNewEntry(new Entry("E15", "AEW", "The more recently"));
    }

    @Test
    public void testPostNewEntry() {

        blog.postNewEntry(new Entry("EX", "AEW", "New Last Entry"));
        assertEquals("New Last Entry", blog.getListPost().get(0).getContent());
    }

    @Test
    public void testShowRecentEntries() {

        assertEquals(10, blog.showRecentEntries().size());
        assertEquals("E15", blog.getListPost().get(0).getTitle());

    }

    @Test
    public void testDeleteExistingEntry() {

        Entry entryD = new Entry("EX", "AEW", "Deleted Entry");
        blog.postNewEntry(entryD);
        blog.deleteExistingEntry(entryD);
        assertEquals("E15", blog.getListPost().get(0).getTitle());

    }

}
