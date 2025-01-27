import java.util.Set;

public class Main {
    // Main method
    public static void main(String[] args) {
        Database db = new Database();

        // actors
        Actor margotRobbie = new Actor("Margot Robbie");
        Actor ryanGosling = new Actor("Ryan Gosling");
        Actor americaFerrera = new Actor("America Ferrera");
        Actor tomHolland = new Actor("Tom Holland");
        Actor zendaya = new Actor("Zendaya");
        Actor jakeGyllenhaal = new Actor("Jake Gyllenhaal");
        Actor caryElwes = new Actor("Cary Elwes");
        Actor dannyGlover = new Actor("Danny Glover");
        Actor monicaPotter = new Actor("Monica Potter");
        Actor mikhailoPoplavsky = new Actor("Mikhailo Poplavsky"); // This actor will not be in any film

        // Add actors
        db.addActor(margotRobbie);
        db.addActor(ryanGosling);
        db.addActor(americaFerrera);
        db.addActor(tomHolland);
        db.addActor(zendaya);
        db.addActor(jakeGyllenhaal);
        db.addActor(caryElwes);
        db.addActor(dannyGlover);
        db.addActor(monicaPotter);
        db.addActor(mikhailoPoplavsky);

        // films
        Film barbie = new Film("Barbie (2023)");
        Film spiderManFFH = new Film("Spider-Man: Far From Home");
        Film saw = new Film("Saw");

        // Add films
        db.addFilm(barbie);
        db.addFilm(spiderManFFH);
        db.addFilm(saw);

        // Add actors to films
        barbie.addActor(margotRobbie);
        barbie.addActor(ryanGosling);
        barbie.addActor(americaFerrera);

        spiderManFFH.addActor(tomHolland);
        spiderManFFH.addActor(zendaya);
        spiderManFFH.addActor(jakeGyllenhaal);

        saw.addActor(caryElwes);
        saw.addActor(dannyGlover);
        saw.addActor(monicaPotter);

        // Task 1
        Set<Actor> actorsWithNoFilms = db.getActorsWithNoFilms();
        if (!actorsWithNoFilms.isEmpty()) {
            System.out.println("Actors who have not acted in any film:");
            for (Actor actor : actorsWithNoFilms) {
                System.out.println("- " + actor.getName());
            }
        } else {
            System.out.println("All actors have acted in at least one film.");
        }

        // Task 2
        Set<Actor> coActorsOfTom = db.getCoActors(tomHolland);
        System.out.println("Actors who have ever played with " + tomHolland.getName() + ": " + coActorsOfTom);

        // Task 3
        Film filmWithMostActors = db.getFilmWithMostActors();
        System.out.println("Film with the most actors: " + filmWithMostActors.getTitle());
    }
}

/** output:
    * Actors who have not acted in any film:
    * - Mikhailo Poplavsky
    * Actors who have ever played with Tom Holland: [Zendaya, Jake Gyllenhaal]
    * Film with the most actors: Barbie (2023)
 */