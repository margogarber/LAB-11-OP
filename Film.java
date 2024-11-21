import java.util.Set;
import java.util.TreeSet;

public class Film implements Comparable<Film> {
    private String title;
    private Set<Actor> actors;

    public Film(String title) {
        this.title = title;
        this.actors = new TreeSet<>(); // TreeSet assumes Actor is Comparable
    }

    public String getTitle() {
        return title;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void addActor(Actor actor) {
        if (!actors.contains(actor)) {
            actors.add(actor);
            actor.addFilm(this); // Ensure the Actor class has addFilm method
        }
    }

    @Override
    public int compareTo(Film other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return title;
    }
}