/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blogg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class Blog {

    private List<Entry> listPost;

    public Blog() {
        listPost = new ArrayList<>();
    }

    public void postNewEntry(Entry entry) {

        listPost.add(0, entry);
    }

    public List<Entry> getListPost() {
        return listPost;
    }

    public void deleteExistingEntry(Entry entry) {

        if (listPost.contains(entry)) {
            listPost.remove(entry);
        }
    }

    public List<Entry> showRecentEntries() {

        List<Entry> res = new ArrayList<>();
        Iterator<Entry> it = listPost.iterator();
        int c = 0;
        while (it.hasNext() && (c < 10)) {
            c++;
            res.add(0, it.next());
        }
        return res;
    }

}
