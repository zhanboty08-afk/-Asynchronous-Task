public abstract class ContentItem {
    private int id;
    private static int idGen;
    private String title;
    private int year;
    public int durationMinutes;

    public ContentItem(String title, int year, int durationMinutes){
        this.id = idGen++;
        setTitle(title);
        setYear(year);
        setduration(durationMinutes);
    }
    public int getId() {
        return id;
    }

    private void setYear(int year) {
        if (year < 1990 || year >2025)
            throw new IllegalArgumentException("Invalid year");
        this.year = year;
    }

    private void setTitle(String title) {
        if (title == null || title.isEmpty())
            throw new IllegalArgumentException("Title cannot be empty");
        this.title = title;
    }

    private void setduration(int durationMinutes) {
        if (durationMinutes<0)
            throw new IllegalArgumentException("Invalid year");
        this.durationMinutes = durationMinutes;
    }

    public int getAge(int currentYear) {
        return currentYear - year;
    }
    public abstract double getLicenseCost(int currentYear);

    public String toString(){
        return "ID: " + id +
                ", title: " + title +
                ", Year: " + year +
                ", duration: " + durationMinutes;
    }
}
