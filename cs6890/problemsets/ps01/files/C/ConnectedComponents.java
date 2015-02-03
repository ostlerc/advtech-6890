/**
 * Name : Chad Ostler
 * ANumber: A00371122
 * Program Description: Read images from stdin and output connected component counts
 */

package cs6890.problemsets.ps01.files.C;
import java.util.Scanner;

public class ConnectedComponents {

    private static class Image {
        public Image(Scanner in) {
            h = in.nextInt();
            w = in.nextInt();
            pixels = new char[h][w];
            for(int y=0; y < h; y++) {
                pixels[y] = in.next().toCharArray();
            }
        }

        public int connectedComponents() {
            int connected = 0;

            for(int x=0; x < w; x++)
                for(int y=0; y < h; y++)
                    if(!isMarked(x, y)) {
                        v = pixels[y][x];
                        markPath(x, y);
                        connected++;
                    }

            return connected;
        }

        private boolean isMarked(int x, int y) {
            return pixels[y][x] == 0;
        }

        // depth-first mark all connected pixels
        private void markPath(int x, int y) {
            // if we're visited, out of bounds, or a different pixel we aren't part of this group
            if(x<0 || y<0 || x+1 > w || y+1 > h || isMarked(x, y) || pixels[y][x] != v)
                return;

            pixels[y][x] = 0;

            markPath(x-1, y); // left
            markPath(x+1, y); // right
            markPath(x, y-1); // up
            markPath(x, y+1); // down
        }

        private char[][] pixels;
        private int w, h; // width and height
        private char v; // pixel value (used in markPath)
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int images = in.nextInt();

        for(int t=0; t < images; t++) {
            Image image = new Image(in);
            System.out.println(image.connectedComponents());
        }
    }
}
