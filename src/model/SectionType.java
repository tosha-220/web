package model;

public enum SectionType {
    OBJECTIVE("Позиция"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATION("Квалификация"),
    EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");
    private String title;
    SectionType(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }
}
