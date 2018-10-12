package hello;

public class Greeting {

    private final long id;
    private final String buildingType;

    public Greeting(long id, String content) {
        this.id = id;
        this.buildingType = content;
    }

    public long getId() {
        return id;
    }

    public String getBuildingType() {
        return buildingType;
    }
}
