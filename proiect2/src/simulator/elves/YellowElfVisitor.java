package simulator.elves;

import database.Child;
import database.Gift;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class YellowElfVisitor implements ChildVisitor {

    private List<Gift> gifts;

    public void setGifts(final List<Gift> gifts) {
        this.gifts = gifts;
    }

    @Override
    public void visit(final Child child) {
        if (child.getReceivedGifts().size() == 0
                && child.getGiftsPreferences().size() > 0) {

            /* list containing only child's preferred gifts,
               sorted ascending by price */
            List<Gift> preferredGiftList = gifts
                    .stream()
                    .filter(gift -> gift.getCategory() == child.getGiftsPreferences().get(0))
                    .sorted(Comparator.comparing(Gift::getPrice))
                    .collect(Collectors.toList());

            /* if the previous list is not empty and if the cheapest gift
               is still available, it is offered to the child */
            if (!preferredGiftList.isEmpty()) {
                Gift yellowElfGift = preferredGiftList.get(0);

                if (yellowElfGift.getQuantity() > 0) {
                    child.getReceivedGifts().add(yellowElfGift);
                    yellowElfGift.setQuantity(yellowElfGift.getQuantity() - 1);
                }
            }
        }
    }
}
