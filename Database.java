import java.util.TreeSet;
import java.util.Iterator;
import java.util.Set;

public class Database {
    private Set<Film> films;
    private Set<Actor> actors;

    public Database() {
        films = new TreeSet<Film>();
        actors = new TreeSet<Actor>();
    }

    public Set<Film> getFilms() {
        return films;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void addFilm(Film film) {
        if (!films.contains(film)) {
            films.add(film);
        }
    }

    public void addActor(Actor actor) {
        if (!actors.contains(actor)) {
            actors.add(actor);
        }
    }

    // Task 1:
    public Set<Actor> getActorsWithNoFilms() {
        Set<Actor> actorsWithNoFilms = new TreeSet<Actor>();
        // Typed iterator
        Iterator<Actor> iterator = actors.iterator();
        while (iterator.hasNext()) {
            Actor actor = iterator.next();
            if (actor.getFilms().isEmpty()) {
                actorsWithNoFilms.add(actor);
            }
        }
        return actorsWithNoFilms;
    }

    // Task 2:
    public Set<Actor> getCoActors(Actor givenActor) {
        Set<Actor> coActors = new TreeSet<Actor>();
        // Typed for-each loop
        for (Film film : givenActor.getFilms()) {
            for (Actor actor : film.getActors()) {
                if (!actor.equals(givenActor) && !coActors.contains(actor)) {
                    coActors.add(actor);
                }
            }
        }
        return coActors;
    }

    // Task 3:
    public Film getFilmWithMostActors() {
        // Untyped iterator
        Iterator iterator = films.iterator();
        Film maxFilm = null;
        int maxActors = 0;
        while (iterator.hasNext()) {
            Film film = (Film) iterator.next();
            int numActors = film.getActors().size();
            if (numActors > maxActors) {
                maxActors = numActors;
                maxFilm = film;
            }
        }
        return maxFilm;
    }
}