package records;

//CANNOT be used for JPA because it needs class features like noArgsConstructor, not final em be mutable
//You can use a 'mirror; Record for a JPA entity class (???) like a DTO
public record ProductRecord(long id, String name, String description) {
    //Compiler creates a final class with 'private final' fields (no need to put final on records, always is final)
    //NOTE: You cannot add other instance fields by hand, BUT you can create a STATIC field (because its class level, not instance level)
    private static final int VALUE = 25;

    //Compiler creates the constructor with all the fields (Canonical Constructor)

    //Compiler also creates the 'getter methods'
    //but instead of the common getId() it generates with the same name as the fiel like: id()

    //You can add class (Records) methods like normal classes

    public boolean hasDescription() {
        return description != null && !description.isBlank();
    }

    //You can override default generated methods
    //BEWARE of use in override acessors
    @Override
    public String name() {
        return name != null && !name.isBlank() ? name : "I have no name :(";
    }
}
