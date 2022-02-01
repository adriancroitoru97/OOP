package lab7.task1;

import  lab7.task1.document.DocumentVisitor;
import lab7.task1.document.DokuWikiVisitor;
import lab7.task1.document.MarkdownVisitor;
import lab7.task1.document.TextSegment;

import java.util.List;

/**
 * Uses visitors to parse documents and provide dokuwiki and markdown outputs.
 */
public class WikiGenerator {

    private final List<TextSegment> textSegments;

    public WikiGenerator(List<TextSegment> textSegments) {
        this.textSegments = textSegments;
    }

    public StringBuilder getDokuWikiDocument() {
        // TODO apply dokuwiki visitor on the text segments
        DocumentVisitor documentVisitor = new DokuWikiVisitor();

        for (TextSegment textSegment: textSegments) {
            textSegment.accept(documentVisitor);
        }

        return documentVisitor.getDocument();
    }

    public StringBuilder getMarkdownDocument() {
        // TODO apply Markdown visitor on the text segments
        DocumentVisitor documentVisitor = new MarkdownVisitor();

        for (TextSegment textSegment: textSegments) {
            textSegment.accept(documentVisitor);
        }

        return documentVisitor.getDocument();
    }
}
