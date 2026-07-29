package SystemDesign;
import java.util.*;
import java.util.*;

/**
 * Production-style Elevator LLD (single file)
 */
public class ElevatorSystem {
    public static void start() {

        Building building = new Building(3);
        ElevatorController controller = building.getController();

        controller.submitExternalRequest(new ExternalRequest(2, Direction.UP));
        controller.submitInternalRequest(1, 8);

        controller.submitExternalRequest(new ExternalRequest(7, Direction.DOWN));
        controller.submitInternalRequest(2, 1);

        controller.submitExternalRequest(new ExternalRequest(5, Direction.UP));
        controller.submitInternalRequest(3, 10);
    }
}

enum Direction { UP, DOWN, IDLE }
enum ElevatorState { IDLE, MOVING, STOPPED }

class ExternalRequest {
    int floor;
    Direction direction;
    ExternalRequest(int floor, Direction direction){
        this.floor=floor;
        this.direction=direction;
    }
}

class InternalRequest {
    int destination;
    InternalRequest(int destination){
        this.destination=destination;
    }
}

class Door {
    void open(){ System.out.println("Door Open"); }
    void close(){ System.out.println("Door Close"); }
}

class Display {
    void show(int id,int floor,Direction direction){
        System.out.println("Display -> Elevator "+id+" Floor="+floor+" Direction="+direction);
    }
}

class Elevator {
    private final int id;
    private int currentFloor=0;
    private Direction direction=Direction.IDLE;
    private ElevatorState state=ElevatorState.IDLE;

    // floor -> number of requests
    private final TreeMap<Integer,Integer> upStops=new TreeMap<>();
    private final TreeMap<Integer,Integer> downStops=new TreeMap<>(Collections.reverseOrder());

    private final Door door=new Door();
    private final Display display=new Display();

    Elevator(int id){
        this.id=id;
    }

    int getId(){ return id; }
    int getCurrentFloor(){ return currentFloor; }
    Direction getDirection(){ return direction; }
    ElevatorState getState(){ return state; }

    void addStop(int floor){
        if(floor>currentFloor){
            upStops.merge(floor,1,Integer::sum);
        }else if(floor<currentFloor){
            downStops.merge(floor,1,Integer::sum);
        }else{
            stopAtCurrentFloor();
        }
    }

    void process(){
        while(!upStops.isEmpty()){
            int next=upStops.firstKey();
            upStops.remove(next);
            move(next);
        }
        while(!downStops.isEmpty()){
            int next=downStops.firstKey();
            downStops.remove(next);
            move(next);
        }
        direction=Direction.IDLE;
        state=ElevatorState.IDLE;
    }

    private void move(int floor){
        direction = floor>currentFloor?Direction.UP:Direction.DOWN;
        state=ElevatorState.MOVING;

        while(currentFloor!=floor){
            currentFloor += (direction==Direction.UP)?1:-1;
            display.show(id,currentFloor,direction);
        }

        state=ElevatorState.STOPPED;
        stopAtCurrentFloor();
    }

    private void stopAtCurrentFloor(){
        System.out.println("Elevator "+id+" stopped at floor "+currentFloor);
        door.open();
        door.close();
    }
}

interface Scheduler{
    Elevator assign(ExternalRequest request,List<Elevator> elevators);
}

class NearestElevatorScheduler implements Scheduler{
    public Elevator assign(ExternalRequest request,List<Elevator> elevators){
        Elevator best=null;
        int bestCost=Integer.MAX_VALUE;

        for(Elevator e:elevators){
            int cost=Math.abs(e.getCurrentFloor()-request.floor);

            if(e.getDirection()!=Direction.IDLE && e.getDirection()!=request.direction){
                cost+=100; // avoid opposite direction
            }

            if(cost<bestCost){
                bestCost=cost;
                best=e;
            }
        }
        return best;
    }
}

class ElevatorController{
    private final List<Elevator> elevators;
    private final Scheduler scheduler;

    ElevatorController(List<Elevator> elevators){
        this.elevators=elevators;
        this.scheduler=new NearestElevatorScheduler();
    }

    public void submitExternalRequest(ExternalRequest request){
        Elevator elevator=scheduler.assign(request,elevators);

        System.out.println("\nAssigned Elevator "+elevator.getId()+" for floor "+request.floor);

        elevator.addStop(request.floor);
        elevator.process();
    }

    public void submitInternalRequest(int elevatorId,int destination){
        Elevator elevator=elevators.stream()
                .filter(e->e.getId()==elevatorId)
                .findFirst()
                .orElseThrow();

        elevator.addStop(destination);
        elevator.process();
    }
}

class Building{
    private final ElevatorController controller;

    Building(int count){
        List<Elevator> elevators=new ArrayList<>();
        for(int i=1;i<=count;i++){
            elevators.add(new Elevator(i));
        }
        controller=new ElevatorController(elevators);
    }

    ElevatorController getController(){
        return controller;
    }
}