package company.inmobi;

public class Item implements Comparable {

    private Integer timeValue;
    private Integer ResCount;
    private ItemType type;

    public Item(Integer timeValue, Integer resCount, ItemType type) {
        this.timeValue = timeValue;
        ResCount = resCount;
        this.type = type;
    }

    public Integer getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(Integer timeValue) {
        this.timeValue = timeValue;
    }

    public Integer getResCount() {
        return ResCount;
    }

    public void setResCount(Integer resCount) {
        ResCount = resCount;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Item) {
            Item otherItem = (Item) o;
            return this.getTimeValue().compareTo(otherItem.getTimeValue());
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Item{" +
                "timeValue=" + timeValue +
                ", ResCount=" + ResCount +
                ", type=" + type +
                '}';
    }
}
