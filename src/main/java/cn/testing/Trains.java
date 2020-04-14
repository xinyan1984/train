package cn.testing;
import java.util.HashSet;

public class Trains {
  private HashSet<Route> routes;

  public int calcDistance(char totalRoute[]) {
    GraphMap gm = new GraphMap();
    int max = totalRoute.length;
    int sum = 0;
    for (int i = 0; i < max - 1; i++) {
      int temp = gm.getDistance(totalRoute[i], totalRoute[i + 1]);
      if(temp==0) return 0;
      sum = sum + temp;
    }
    return sum;
  }

  public void calcAllKindsOfTrips(char start, char end, int maxStops, int unlimitedDistance) {
    GraphMap gm = new GraphMap();
    int maxDistance = -1;
    routes = gm.makeRouteFromStart2End(start, end, maxStops, maxDistance);
  }

  public void getNumOfRouteInThisTrip() {
    int total = routes.size();
    int sum =0;
    for(Route route:routes)
    {
      if( route.distance<30 )
      {
        sum++;
      }
    }
    System.out.println("Output#10: "+  sum);
  }

  public void getShotestRouteDistance(int num) {
    int initDistance=100000;
    for(Route route:routes)
    {
      if( route.distance<initDistance )
      {
        initDistance=route.distance;
      }
    }
    System.out.println("Output#"+num+": "+  initDistance);
  }

  public void getNumOfRouteExactlyStops() {
    int sum =0;
    for(Route route:routes)
    {
      if( route.path.length()==5 )
      {
       sum++;
      }
    }
    System.out.println("Output#7: "+  sum);
  }

  public void getNumOfRouteInThisMaxStops() {
    int sum =0;
    for(Route route:routes)
    {
      if( route.path.length()<=4 )
      {
        sum++;
      }
    }
    System.out.println("Output#6: "+  sum);
  }
}
