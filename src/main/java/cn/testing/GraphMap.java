package cn.testing;

import java.util.HashSet;

public class GraphMap {
  private static final char START_NODE = 'A';
  public static final int OPTIMAL_ALGORITHM = -1;
  public static final int UNLIMITED_DISTANCE = -1;
  private static HashSet<Route> routes;

  /**
   * Map of ABCDE places.
   * Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7 .
   **/
  private int[][] map = {
          /** A  B  C  D  E **/
          /** A **/{0, 5, 0, 5, 7},
          /** B **/{0, 0, 4, 0, 0},
          /** C **/{0, 0, 0, 8, 2},
          /** D **/{0, 0, 8, 0, 6},
          /** E **/{0, 3, 0, 0, 0}
  };

  public static void main(String[] args) {
    GraphMap gm = new GraphMap();
    char start = 'C';
    char end = 'C';
    int stops = 2;
    int maxDistance = -1;
    gm.makeRouteFromStart2End(start, end, stops, maxDistance);
  }

  /**
   * Get the distance of the route which you input.
   *
   * @param start: Position of starting.
   * @param end:   Position of ending.
   * @return The distance between 'start' and 'end'.
   */
  public int getDistance(char start, char end) {
    return getLengthByIndex(start - START_NODE, end - START_NODE);
  }

  /**
   * Find all routes from 'start' to 'end'.
   *
   * @param start:       The starting of route.
   * @param end:         The ending of route.
   * @param maxStops:       The max stops in this route.
   * @param maxDistance: The max distance in this route.
   * @return The trip contains all routes from 'start' to 'end'.
   */
  public HashSet<Route> makeRouteFromStart2End(char start, char end, int maxStops, int maxDistance) {
    if (!checkPosition(start - START_NODE, end - START_NODE)) {
      return null;
    }
    // init routes param
     routes = new HashSet<Route>();
     search(start - START_NODE, end - START_NODE, "" + start, 0, maxStops, maxDistance);
    return routes;
  }

  /**
   * find all routes that meet the requirements.
   *
   * @param x
   * @param y
   */
  private void search(int x, int y, String path, int distance, int stops, int maxDistance) {
    for (int i = 0; i < map[x].length; i++) {
      // 1.exist a route;
      // 2.stops < requirement stops;
      // 3.eliminate the starting;
      // 4.don't walk repeated station.
      // 5.distance < maxDistance
      if (map[x][i] > 0 && (stops > 0 ? (path.length() < stops + 1) : (!path.substring(1).contains(String.valueOf((char) (i + START_NODE)))))
              && (maxDistance > 0 ? (distance < maxDistance - map[x][i]) : true)) {
        // arrive the ending
        if (i == y) {
          routes.add(new Route(path + (char) (y + START_NODE), distance + map[x][i]));
         // System.out.println("path=" + path + (char) (y + START_NODE) + ", distance=" + (distance + map[x][i]));
        }
        search(i, y, path + (char) (i + START_NODE), distance + map[x][i], stops, maxDistance);
      }
    }
  }

  /**
   * Get the distance by index in this map.
   *
   * @param x: X-axis in this map.
   * @param y: Y-axis in this map.
   * @return 0 represents illegal params or there doesn't exist the route between x and y.
   */
  private int getLengthByIndex(int x, int y) {
    if (!checkPosition(x, y)) {
      return 0;
    }
    return map[x][y];
  }

  /**
   * x,y params must be legal in this situation
   *
   * @param x
   * @param y
   * @return
   */
  private boolean checkPosition(int x, int y) {
    if (x < 0 || y < 0 || x > map.length || y >= map.length) {
      return false;
    }
    return true;
  }

  public int[][] getMap() {
    return map;
  }

  public void setMap(int[][] map) {
    this.map = map;
  }


}
