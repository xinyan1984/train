1.import project into idea IDE;
2.run cn.TrainsTest

Function Design

1.Class Info：
GraphMap class provides the basic data and function, such as calculator the distance of two station and record all routes comply with the request
makeTripFromStart2End(char start, char end, int stops, int maxDistance) will calculator all route from start to end UNLIMITED_STOPS or UNLIMITED_DISTANCE means 
there is no any limit for stops and distance
Route Class define the basic info about the route, such as distance, path;
Trains class define many methods to deal with different request and return related result.
TrainsTest class is the junit test codes

