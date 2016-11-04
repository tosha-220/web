package model;


public class Link {
    private final String fullName;
    private final String url;

    public Link(String fullName, String url) {
        this.fullName = fullName;
        this.url = url;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUrl() {
        return url;
    }

    public Link() {
        this("dsd",null);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        return fullName.equals(link.fullName) && (url != null ? url.equals(link.url) : link.url == null);

    }

    @Override
    public String toString() {
        return "Link{" +
                "fullName='" + fullName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = fullName.hashCode();
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
