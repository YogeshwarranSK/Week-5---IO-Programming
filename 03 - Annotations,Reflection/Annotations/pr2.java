package Day25.Annotations;
class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("Old feature - do not use");
    }

    public void newFeature() {
        System.out.println("New feature - use this instead");
    }
}

public class pr2 {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}

