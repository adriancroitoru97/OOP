package lab7.task1.document;

public interface DocumentVisitor {
    void visit(ItalicTextSegment italicTextSegment);
    void visit(BoldTextSegment boldTextSegment);
    void visit(UrlSegment urlSegment);
    void visit(PlainTextSegment plainTextSegment);
    StringBuilder getDocument();
}
