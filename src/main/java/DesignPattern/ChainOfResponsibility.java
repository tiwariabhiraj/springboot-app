package DesignPattern;

 class LeaveRequest {

    private int days;

    public LeaveRequest(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
}

 abstract class Approver {

    protected Approver nextApprover;

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public abstract void approve(LeaveRequest request);
}

class Director extends Approver {

    @Override
    public void approve(LeaveRequest request) {

        System.out.println("Approved by Director");
    }
}
 class Manager extends Approver {

    @Override
    public void approve(LeaveRequest request) {

        if(request.getDays() <= 5) {

            System.out.println("Approved by Manager");

        } else {

            nextApprover.approve(request);
        }
    }
}
class TeamLead extends Approver {

    @Override
    public void approve(LeaveRequest request) {

        if(request.getDays() <= 2) {

            System.out.println("Approved by Team Lead");

        } else {
            nextApprover.approve(request);
        }
    }
}

public class ChainOfResponsibility {
     public void start(){
         Approver teamLead = new TeamLead();

         Approver manager = new Manager();

         Approver director = new Director();

         teamLead.setNextApprover(manager);

         manager.setNextApprover(director);

         LeaveRequest request = new LeaveRequest(4);

         teamLead.approve(request);
     }
}