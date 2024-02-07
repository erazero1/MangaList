public class Manga {
    private String mangaID;
    private String title;
    private String author;
    private String yearOfRelease;
    private String titleStatus;
    private String amountOfChapters;
    private String rating;
    public Manga(){}

    public Manga(String title, String author, String yearOfRelease, String titleStatus, String amountOfChapters, String rating) {
        this.title = title;
        this.author = author;
        this.yearOfRelease = yearOfRelease;
        this.titleStatus = titleStatus;
        this.amountOfChapters = amountOfChapters;
        this.rating = rating;
    }

    public Manga(String mangaID, String title, String author, String yearOfRelease, String titleStatus, String amountOfChapters, String rating) {
        this.mangaID = mangaID;
        this.title = title;
        this.author = author;
        this.yearOfRelease = yearOfRelease;
        this.titleStatus = titleStatus;
        this.amountOfChapters = amountOfChapters;
        this.rating = rating;
    }



    public String getMangaID() {
        return mangaID;
    }

    public void setMangaID(String mangaID) {
        this.mangaID = mangaID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getTitleStatus() {
        return titleStatus;
    }

    public void setTitleStatus(String titleStatus) {
        this.titleStatus = titleStatus;
    }

    public String getAmountOfChapters() {
        return amountOfChapters;
    }

    public void setAmountOfChapters(String amountOfChapters) {
        this.amountOfChapters = amountOfChapters;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
