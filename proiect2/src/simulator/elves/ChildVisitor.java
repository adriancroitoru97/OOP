package simulator.elves;

import database.Child;

/**
 * Visitor pattern applied on Elves and Child objects. There are 3 types
 * of Elves which implement the following interface.
 */
public interface ChildVisitor {
    /**
     * visit method implemented by each elf
     *
     * @param child the visitable object
     */
    void visit(Child child);
}
