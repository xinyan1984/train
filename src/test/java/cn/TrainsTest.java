package cn;

import cn.testing.GraphMap;
import cn.testing.Trains;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrainsTest {

  private Trains train = new Trains();

  // 1.The distance of the route A-B-C.
  @Test
  public void test0() {
    char[] route = {'A', 'B', 'C'};
    int result = train.calcDistance(route);
    System.out.println("Output#1:  " + (result > 0 ? result : " NO SUCH ROUTE"));
  }

  // 2.The distance of the route A-D.
  @Test
  public void test1() {
    char[] route = {'A', 'D'};
    int result = train.calcDistance(route);
    System.out.println("Output#2:  " + (result > 0 ? result : " NO SUCH ROUTE"));
  }

  // 3.The distance of the route A-D-C.
  @Test
  public void test2() {
    char[] route = {'A', 'D', 'C'};
    int result = train.calcDistance(route);
    System.out.println("Output#3:  " + (result > 0 ? result : " NO SUCH ROUTE"));

  }

  // 4.The distance of the route A-E-B-C-D.
  @Test
  public void test3() {
    char[] route = {'A', 'E', 'B', 'C', 'D'};
    int result = train.calcDistance(route);
    System.out.println("Output#4:  " + (result > 0 ? result : " NO SUCH ROUTE"));
  }

  // 5.The distance of the route A-E-D.
  @Test
  public void test4() {
    char[] route = {'A', 'E', 'D'};
    int result = train.calcDistance(route);
    System.out.println("Output#5:  " + (result > 0 ? result : " NO SUCH ROUTE"));

  }

  // 6.The number of trips starting at C and ending at C with a maximum of 3 stops. In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops).
  @Test
  public void test5() {
    train.calcAllKindsOfTrips('C', 'C', 3, GraphMap.UNLIMITED_DISTANCE);
    train.getNumOfRouteInThisMaxStops();
  }

  // 7.The number of trips starting at A and ending at C with exactly 4 stops. In the sample data below, there are three such trips: A to C (via B,C,D); A to C (via D,C,D); and A to C (via D,E,B).
  @Test
  public void test6() {
    int stops = 4;
    train.calcAllKindsOfTrips('A', 'C', 4, GraphMap.UNLIMITED_DISTANCE);
    train.getNumOfRouteExactlyStops();

  }

  // 8.The length of the shortest route (in terms of distance to travel) from A to C.
  @Test
  public void test7() {
    train.calcAllKindsOfTrips('A', 'C', GraphMap.OPTIMAL_ALGORITHM, GraphMap.UNLIMITED_DISTANCE);
    train.getShotestRouteDistance(8);

  }

  // 9.The length of the shortest route (in terms of distance to travel) from B to B.
  @Test
  public void test8() {
    train.calcAllKindsOfTrips('B', 'B', GraphMap.OPTIMAL_ALGORITHM, GraphMap.UNLIMITED_DISTANCE);
    train.getShotestRouteDistance(9);
  }

  // 10.The number of different routes from C to C with a distance of less than 30. In the sample data, the trips are: CDC, CEBC, CEBCDC, CDCEBC, CDEBC, CEBCEBC, CEBCEBCEBC.
  @Test
  public void test9() {
    int maxDistance = 30;
    train.calcAllKindsOfTrips('C', 'C', 20, maxDistance);
    train.getNumOfRouteInThisTrip();
  }

}
