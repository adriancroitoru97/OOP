package lab7.task1.document;

public class UrlSegment extends TextSegment {
    private String url;
    private String description;

    public UrlSegment(String url, String description) {
        super(url + description);
        this.url = url;
        this.description = description;
    }

    @Override
    public void accept(DocumentVisitor v) {
        v.visit(this);
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
}
