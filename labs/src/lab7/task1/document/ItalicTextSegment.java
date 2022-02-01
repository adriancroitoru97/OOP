package lab7.task1.document;

public class ItalicTextSegment extends TextSegment{
    public ItalicTextSegment(String content) {
        super(content);
    }

    @Override
    public void accept(DocumentVisitor v) {
        v.visit(this);
    }
}
