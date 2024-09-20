public enum Continent {
    AFRICA,
    ANTARCTICA,
    ASIA,
    EUROPE,
    NORTH_AMERICA,
    OCEANIA,
    SOUTH_AMERICA;


    public String getDescription() {
        switch(this) {
            case AFRICA:
                return "Africa";
            case ANTARCTICA:
                return "Antarctica";
            case ASIA:
                return "Asia";
            case EUROPE:
                return "Europe";
            case NORTH_AMERICA:
                return "North America";
            case OCEANIA:
                return "Oceania";
            case SOUTH_AMERICA:
                return "South America";
            default:
                return "Unknown Continent";
        }
    }
}
