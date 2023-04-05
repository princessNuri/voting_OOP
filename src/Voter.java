// Класс Избиратель
class Voter {
    private String name;
    private boolean hasVoted;

    public Voter(String name) {
        this.name = name;
        this.hasVoted = false;
    }

    public String getName() {
        return name;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }
}
