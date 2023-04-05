import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Класс Система голосования
class VotingSystem {
    private ArrayList<Voter> voters;
    private ArrayList<Candidate> candidates;

    public VotingSystem() {
        this.voters = new ArrayList<Voter>();
        this.candidates = new ArrayList<Candidate>();
    }

    // Регистрация избирателя
    public void registerVoter(String name) {
        voters.add(new Voter(name));
    }

    // Добавление кандидата
    public void addCandidate(String name) {
        candidates.add(new Candidate(name));
    }
    public void addVoter(String name) {
        voters.add(new Voter(name));
    }

    // Получение списка кандидатов
    public ArrayList<Candidate> getCandidates() {
        return candidates;
    }

    public ArrayList<Voter> getVoters() {
        return voters;
    }

    // Голосование избирателя за кандидата
    public void vote(Scanner scanner) {
        System.out.print("Введите имя избирателя: ");
        System.out.println("(Избиратель 1,Избиратель 2,Избиратель 3,Избиратель 4,Избиратель 5)");
        String voterName = scanner.nextLine();

        System.out.print("Введите имя кандидата: ");
        System.out.println("(Кандидат 1,Кандидат 2,Кандидат 3,Кандидат 4,Кандидат 5)");
        String candidateName = scanner.nextLine();

        Voter voter = findVoter(voterName);
        Candidate candidate = findCandidate(candidateName);

        if (voter == null || candidate == null) {
            System.out.println("Ошибка: неверное имя избирателя или кандидата.");
            return;
        }

        if (voter.hasVoted()) {
            System.out.println("Ошибка: этот избиратель уже голосовал.");
            return;
        }

        candidate.incrementVotes();
        voter.setHasVoted(true);

        System.out.println("Голос от " + voter.getName() + " за " + candidate.getName() + " принят.");
    }


    // Поиск избирателя по имени
    private Voter findVoter(String name) {
        for (Voter voter : voters) {
            if (voter.getName().equals(name)) {
                return voter;
            }
        }

        return null;
    }

    // Поиск кандидата по имени
    private Candidate findCandidate(String name) {
        for (Candidate candidate : candidates) {
            if (candidate.getName().equals(name)) {
                return candidate;
            }
        }

        return null;
    }

    // Подсчет результатов голосования
    public List<Candidate> countVotes() {
        System.out.println("Результаты голосования:");
        for (Candidate candidate : candidates) {
            System.out.println(candidate.getName() + ": " + candidate.getVotes());
        }
        return null;
    }
}
