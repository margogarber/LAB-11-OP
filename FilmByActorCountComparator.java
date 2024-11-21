import java.util.Comparator;

public class FilmByActorCountComparator implements Comparator<Film> {
    @Override
    public int compare(Film f1, Film f2) {
        return Integer.compare(f1.getActors().size(), f2.getActors().size());
    }
}

