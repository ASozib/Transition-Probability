import java.util.ArrayList;
import java.util.Random;

public class State {
    static int n;
    double E=Math.exp(n);
    int []Q;

    public State() {
        Q = new int[n];
    }

    public State(int[] q) {
        Q = q;
    }

    public int objective()
    {
        int f=0;

        for (int i=0; i<n; ++i)
        {
            for (int j=i+1; j<n; ++j)
            {
                if (Q[i]==Q[j] || Math.abs(Q[i]-Q[j])== Math.abs(i-j))
                {
                    f++;
                }
            }
        }

        return f;
    }

    public ArrayList<State> get_successors()
    {
        ArrayList<State> successors = new ArrayList<>();

        for (int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if (j!=Q[i])
                {
                    State s=new State();
                    for (int k=0; k<n; ++k)
                    {
                        s.Q[k]=Q[k];
                    }

                    s.Q[i] = j;
                    successors.add(s);
                }
            }
        }

        return successors;
    }

    public State get_best_successor()
    {
        State best=new State();
        int bestVal = Integer.MAX_VALUE;

        ArrayList<State> successors = get_successors();

        for (State o: successors)
        {
            if (o.objective()<bestVal) {
                best = o;
                bestVal = o.objective();
            }
        }

        return best;
    }

    public State get_random_neighbour()
    {
        State s = new State();
        Random r = new Random();

        for (int i=0; i<n; i++)
        {
            s.Q[i]=Q[i];
        }

        s.Q[r.nextInt(n)] = r.nextInt(n);

        return s;
    }

    public boolean goal_test()
    {
        return objective()==0;
    }

    public static State get_random_state()
    {
        State s = new State();
        Random random = new Random();

        for (int i=0; i<n; i++)
        {
            s.Q[i] = random.nextInt(n);
        }

        return s;
    }

    @Override
    public String toString() {
        String s="[ ";
        for (int i=0; i<n; ++i)
        {
            s+=(Q[i] +" ");
        }
        s+= "]";

        return s;

        //return
    }
}