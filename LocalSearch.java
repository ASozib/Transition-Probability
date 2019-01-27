import  java.util.Random;

public class LocalSearch {
    static int noOfState=0, noOfRestart=0;

    public static State StimulatedAnnihiling(){
        State current = State.get_random_state();
        ++noOfState;

        while (true) {
            System.out.println(current+ " :" + current.objective());

            if (current.goal_test()){
                break;
            }

            boolean f=false;

            for (int i=0; i<100; i++)
            {
                State firstSuccessor = current.get_random_neighbour();

                if (firstSuccessor.objective()<current.objective())
                {
                    f=true;
                    current=firstSuccessor;
                    break;
                }
            }
            if(f==false)
                break;
        }

        return current;
    }



    public static State simulated_annealing()
    {
        Random r = new Random();
        State current = State.get_random_state();
        double T=1000;//temperature
        double alpha=0.99;


        while (true)
        {


            System.out.println(current+": "+current.objective());
            if (current.goal_test())
                break;

                State successor = current.get_random_neighbour();

                double imp = successor.E - current.E;


                double Transitionprobablity = 1 / (1 + Math.exp(-imp / T));
                double FloatingRandom = r.nextDouble();
                if (FloatingRandom <= Transitionprobablity)

                    current = successor;



            else if (FloatingRandom>Transitionprobablity)
                 current=current;
            T = alpha * T;


        }

        return current;
    }
























}