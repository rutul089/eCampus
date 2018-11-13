package rutul.com.ecampus.model;

public class SliderData {
    private int sliderId, sliderImg;
    private String sliderImageUrl;
    private String sliderLabel;
    private String sliderDescription;
    private String sliderDate;
    private String sliderPostedBy;

    public SliderData(int sliderId, int sliderImg, String sliderImageUrl, String sliderDescription, String sliderDate) {
        this.sliderId = sliderId;
        this.sliderImg = sliderImg;
        this.sliderImageUrl = sliderImageUrl;
        this.sliderDescription = sliderDescription;
        this.sliderDate = sliderDate;
    }

    public SliderData(int sliderId, int sliderImg, String sliderImageUrl, String sliderLabel, String sliderDescription, String sliderDate, String sliderPostedBy) {
        this.sliderId = sliderId;
        this.sliderImg = sliderImg;
        this.sliderImageUrl = sliderImageUrl;
        this.sliderLabel = sliderLabel;
        this.sliderDescription = sliderDescription;
        this.sliderDate = sliderDate;
        this.sliderPostedBy = sliderPostedBy;
    }

    public int getSliderId() {
        return sliderId;
    }

    public void setSliderId(int sliderId) {
        this.sliderId = sliderId;
    }

    public int getSliderImg() {
        return sliderImg;
    }

    public void setSliderImg(int sliderImg) {
        this.sliderImg = sliderImg;
    }

    public String getSliderImageUrl() {
        return sliderImageUrl;
    }

    public void setSliderImageUrl(String sliderImageUrl) {
        this.sliderImageUrl = sliderImageUrl;
    }

    public String getSliderLabel() {
        return sliderLabel;
    }

    public void setSliderLabel(String sliderLabel) {
        this.sliderLabel = sliderLabel;
    }

    public String getSliderDescription() {
        return sliderDescription;
    }

    public void setSliderDescription(String sliderDescription) {
        this.sliderDescription = sliderDescription;
    }

    public String getSliderDate() {
        return sliderDate;
    }

    public void setSliderDate(String sliderDate) {
        this.sliderDate = sliderDate;
    }

    public String getSliderPostedBy() {
        return sliderPostedBy;
    }

    public void setSliderPostedBy(String sliderPostedBy) {
        this.sliderPostedBy = sliderPostedBy;
    }
}
