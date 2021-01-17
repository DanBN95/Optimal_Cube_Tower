public class Cube {

    private int Length;
    private int Width;
    private int Height;

    public int getLength() {
        return Length;
    }

    public void setLength(int length) {
        Length = length;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        Width = width;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public Cube(int length, int width, int height) {
        this.Length=length;
        this.Width=width;
        this.Height=height;
    }

    public void printOneCube() {
        for(int i=0;i<Length;i++)
            System.out.print("*");
        System.out.println("\n");
        for(int j=0;j<Height-2;j++) {
            System.out.print("*");
            for(int k=0;k<Length-2;k++)
                System.out.print(" ");
            System.out.println("*\n");
        }
        for(int i=0;i<Length;i++)
            System.out.print("*");
    }
}

