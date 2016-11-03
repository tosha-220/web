package model;

public enum ContactType {
    PHONE("Тел"),
    MOBILE("Мобильный тел"),
    HOME_PAGE("Домашняя страница"),
    SKYPE("Skype"),
    MAIL("Mail"),
    ICQ("ICQ");
    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
