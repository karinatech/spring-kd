package service;

import implementation.Mentor;

public class FullTimeMentor implements Mentor {

    @Override
    public void createAccounts() {
        System.out.println("Full time mentor account is created");
    }
}
