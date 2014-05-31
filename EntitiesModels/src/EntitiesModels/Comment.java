/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels;

/**
 *
 * @author Krzysztof
 */
public class Comment {

    private final long ID;
    private final long testID;
    private final String content;
    private final int rating;

    public Comment(long ID, long testID, String content, int rating) {
        this.ID = ID;
        this.testID = testID;
        this.content = content;
        this.rating = (rating % 10) + 1;
    }

    public long getID() {
        return ID;
    }

    public long getTestID() {
        return testID;
    }

    public String getContent() {
        return content;
    }

    public int getRating() {
        return rating;
    }
}
