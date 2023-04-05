import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        fillCandidateList(votingSystem);
        Administrator administrator = new Administrator(votingSystem);
        conductElections(votingSystem);
        votingSystem.countVotes();
    }

    // Заполнение списка кандидатов
    public static void fillCandidateList(VotingSystem votingSystem) {
        votingSystem.addCandidate("Кандидат 1");
        votingSystem.addCandidate("Кандидат 2");
        votingSystem.addCandidate("Кандидат 3");
        votingSystem.addCandidate("Кандидат 4");
        votingSystem.addCandidate("Кандидат 5");
    }

    // Проведение выборов
    public static void conductElections(VotingSystem votingSystem) {
        if (votingSystem.getCandidates().isEmpty()) {
            System.out.println("В системе нет кандидатов!");
            return;
        }
        // Регистрация избирателей
        votingSystem.registerVoter("Избиратель 1");
        votingSystem.registerVoter("Избиратель 2");
        votingSystem.registerVoter("Избиратель 3");
        votingSystem.registerVoter("Избиратель 4");
        votingSystem.registerVoter("Избиратель 5");
        if (votingSystem.getVoters().isEmpty()) {
            System.out.println("В системе нет избирателей!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        votingSystem.vote(scanner);
        votingSystem.vote(scanner);
        votingSystem.vote(scanner);
        votingSystem.vote(scanner);
        votingSystem.vote(scanner);


        if (votingSystem.getVoters().isEmpty()) {
            System.out.println("В выборах не приняли участие ни один избиратель!");
            return;
        }

        // Подсчет результатов
        List<Candidate> result = votingSystem.getCandidates();
        System.out.println("Результаты голосования:");
        for (Candidate candidate : result) {
            System.out.println(candidate.getName() + " - " + candidate.getVotes() + " голосов");
        }
    }
}