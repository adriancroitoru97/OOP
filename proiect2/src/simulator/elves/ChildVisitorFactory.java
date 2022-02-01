package simulator.elves;

import enums.ElvesType;

/**
 * Factory pattern used for creating the right ChildVisitor
 * object based on the type of elf given as parameter.
 */
public final class ChildVisitorFactory {

    /**
     * Instantiates the right ChildVisitor object.
     *
     * @param elf the type of elf as it's given in the input
     * @return the corresponding ChildVisitor object
     */
    public ChildVisitor createVisitor(final ElvesType elf) {

        return switch (elf) {
            case PINK -> new PinkElfVisitor();
            case BLACK -> new BlackElfVisitor();
            case YELLOW -> new YellowElfVisitor();
            case WHITE -> null;
        };
    }
}
