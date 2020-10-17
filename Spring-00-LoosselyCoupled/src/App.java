import service.FullTimeMentor;
import service.MentorAccount;
import service.PartTimeMentor;

public class App {
    public static void main(String[] args) {
        FullTimeMentor fullTimeMentor= new FullTimeMentor();
        PartTimeMentor partTimeMentor= new PartTimeMentor();
        MentorAccount mentorAccount=new MentorAccount(fullTimeMentor);
        MentorAccount mentorAccount1=new MentorAccount(partTimeMentor);
        mentorAccount.manageAccount();
        mentorAccount1.manageAccount();
    }
}
