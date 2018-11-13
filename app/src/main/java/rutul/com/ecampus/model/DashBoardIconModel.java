package rutul.com.ecampus.model;

import rutul.com.ecampus.utils.Constants;

public class DashBoardIconModel {

    private Constants.SCREEN mypost;
    private String label;
    private int image;

    public DashBoardIconModel(Constants.SCREEN mypost, String label, int image) {
        this.mypost = mypost;
        this.label = label;
        this.image = image;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Constants.SCREEN getMypost() {
        return mypost;
    }

    public void setMypost(Constants.SCREEN mypost) {
        this.mypost = mypost;
    }


}
