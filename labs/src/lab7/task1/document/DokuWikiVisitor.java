package lab7.task1.document;

public class DokuWikiVisitor implements DocumentVisitor{
    StringBuilder newDocument = new StringBuilder();

    @Override
    public void visit(ItalicTextSegment italicTextSegment) {
        newDocument.append("//").append(italicTextSegment.getContent()).append("//");
    }

    @Override
    public void visit(BoldTextSegment boldTextSegment) {
        newDocument.append("**").append(boldTextSegment.getContent()).append("**");
    }

    @Override
    public void visit(UrlSegment urlSegment) {
        newDocument.append("[[").append(urlSegment.getUrl()).append('|').
                append(urlSegment.getDescription()).append("]]");
    }

    @Override
    public void visit(PlainTextSegment plainTextSegment) {
        newDocument.append(plainTextSegment.getContent());
    }

    @Override
    public StringBuilder getDocument() {
        return newDocument;
    }
}
