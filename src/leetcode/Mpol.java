package leetcode;

public class Mpol {
    //max-points-on-a-line
    public static int maxPoints(Point[] points) {
        if(points.length<=2) return points.length;

        int maxNumbers = 2;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int count = 2;
                for(int k = j+1;k<points.length;k++){
                    //重复点直接++
                    if ((points[k].x == points[i].x && points[k].y == points[i].y) ||
                            (points[k].x == points[j].x && points[k].y == points[j].y)) {
                        count++;
                        if (count > maxNumbers)
                            maxNumbers = count;
                        continue;
                    }

                    //垂直点判断
                    if (points[k].x == points[j].x) {
                        if (points[j].x == points[i].x) {
                            count++;
                            if (count > maxNumbers)
                                maxNumbers = count;
                            continue;
                        } else
                            continue;
                    } else if (points[j].x == points[i].x) {
                        continue;
                    }

                    if((points[k].y-points[j].y)/(float)(points[k].x-points[j].x) ==
                            (points[j].y-points[i].y)/(float)(points[j].x-points[i].x)) count++;
                    if(count>maxNumbers) maxNumbers = count;
                }
            }
        }
        return maxNumbers;

    }


    static class Point {
        int x;int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
}
