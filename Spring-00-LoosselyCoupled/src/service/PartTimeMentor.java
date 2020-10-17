package service;

import implementation.Mentor;

public class PartTimeMentor implements Mentor {
    @Override
    public void createAccounts() {
        System.out.println("Part time mentor account is created");
    }
}
