/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecentFileList;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class RecentFileList {

    private List<String> recentFileList;
    private static final int LIST_FULL = 15;

    public RecentFileList() {

        recentFileList = new ArrayList<>();

    }

    public boolean listEmpty() {

        return recentFileList.isEmpty();

    }

    public boolean fileExists(String file) {

        return recentFileList.contains(file);
    }

    public List<String> getRecentFileList() {
        return recentFileList;
    }

    public boolean listFull() {

        return recentFileList.size() == LIST_FULL;

    }

    public void addFile(String file) {

        if (fileExists(file)) {
            recentFileList.remove(file);
        }
        if (listFull()) {
            recentFileList.remove(LIST_FULL - 1);
        }
        recentFileList.add(0, file);
    }

}
