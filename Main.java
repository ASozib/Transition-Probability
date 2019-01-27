public class Main {
    public static void main(String[] args) {
        State.n=8;

        State end = LocalSearch.simulated_annealing();

        System.out.println("End Solution");
        System.out.println(end+" :"+end.objective());
        //System.out.println(end.goal_test());
        //System.out.println("No. of total states: "+LocalSearch.noOfState+"\nNo. of total restart: "+LocalSearch.noOfRestart);
    }
}