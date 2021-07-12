package pattern.observer.listen;

public class Event {
    private Person person;
    public Event() {
    }

    public Event(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
