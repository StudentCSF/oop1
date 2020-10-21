package course2.oop.task1;

public final class MainServiceRapporteur {
    private boolean silent;

    public final void report(final String statement)
    {
        if (!silent) {
            System.out.println(statement);
        }
    }

    public final void silence() {
        silent = true;
    }

    public final boolean canSpeak() {
        return !silent;
    }

    public final void speak() {
        silent = false;
    }
}
