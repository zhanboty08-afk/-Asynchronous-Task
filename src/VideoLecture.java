public class VideoLecture extends ContentItem implements Downloadable {
    private String quality;

    public VideoLecture(String title, int year, int durationMinutes,String quality){
        super(title, year, durationMinutes);
        setQuality(quality);
    }
    public String getQuality() {
        return quality;
    }

    private void setQuality(String quality) {
        if (quality == null || quality.isBlank()) {
            throw new IllegalArgumentException("Quality cannot be null or blank");
        }
        this.quality = quality;
    }


    public double getLicenseCost(int currentYear) {
        int age = getAge(currentYear);
        int ageFactor = (age <= 2) ? 5 : 2;
        return 0.05 * durationMinutes + ageFactor;
    }

    public void download() {
        System.out.println("Downloading video in " + quality + "...");
    }

    public int getMaxDownloadsPerDay() {
        return 3;
    }
    public String toString() {
        return "VideoLecture {" + super.toString() +
                ", quality='" + quality + '\'' +
                '}';
    }
}
