import java.util.Random;
import java.util.Scanner;

public class PrintCube {

    public static void main(String [] args){

        System.out.println("******************************************************************************");
        System.out.println("\t\tprinting first Cube-Tower with 20 Cubes!");
        System.out.println("******************************************************************************\n\n");
        Print(20);
        System.out.println("\n");
        System.out.println("******************************************************************************");
        System.out.println("\t\tprinting second Cube-Tower with 30 Cubes!");
        System.out.println("******************************************************************************\n\n");
        Print(30);

    }

    public static void Print(int numOfCubes) {
        Scanner in=new Scanner(System.in);
        Random rand = new Random();
        boolean flag = false;
        int length,width,height,h,maxVal=0;
        int saveMaxIndex=0;
        int [] MaxH = new int[numOfCubes];

        int [] P = new int[numOfCubes];
        for(int k=0;k<numOfCubes;k++)
            P[k]=-1;

        System.out.println("First time = 20 Cubes");
        Cube [] cube = new Cube[numOfCubes];
        for(int i=0;i<numOfCubes;i++) {
            length=rand.nextInt(999)+1;
            width = rand.nextInt(999)+1;
            height = rand.nextInt(999)+1;
            cube[i]=new Cube(length,width,height);
        }
        MaxH[0]=cube[0].getHeight();
        maxVal=MaxH[0];
        P[0]=0;

        for(int i=1;i<numOfCubes;i++){
//            MaxH[i]=cube[i].getHeight();
            for(int j=0;j<=i-1;j++) {

                if((cube[i].getLength()>cube[j].getLength() && cube[i].getWidth()>cube[j].getWidth())
                        || ((cube[i].getLength()<cube[j].getLength() && cube[i].getWidth()<cube[j].getWidth()))) {

                    if (flag == false) {
                        h = cube[i].getHeight() + MaxH[j];
                    } else {
                        MaxH[j] = MaxH[P[i]] + cube[j].getHeight();
                        P[j] = P[i];
                        h = cube[i].getHeight() + MaxH[j];
                    }
                }
                else {
                    h=0;
                }
                if(MaxH[i]<h){
                    MaxH[i]=h;
                    P[i]=j;
                }
                else if(MaxH[i]>MaxH[j])
                    flag=true;
                else
                    continue;

            }
            flag=false;
            if(MaxH[i]==0)
                MaxH[i]=cube[i].getHeight();
            if(MaxH[i]>maxVal){
                maxVal=MaxH[i];
                saveMaxIndex=i;
            }
        }
        System.out.println("Cube Array:");
        printCubesArray(cube,numOfCubes);
        System.out.println("\n");
        int count=0;
        int save=saveMaxIndex;
        while(true){
            if(save==P[save]) {
                count++;
                break;
            }
            save=P[save];
            if(save==-1)
                break;
            count++;
        }
        Cube[] pCube=new Cube[count];
        pCube[0]=cube[saveMaxIndex];
        for(int i=1;i<count;i++){
            pCube[i]=cube[P[saveMaxIndex]];
            saveMaxIndex=P[saveMaxIndex];
        }
        System.out.println("Selected Cubes to bulid tower made of cubes: ");
        printCubesArray(pCube,count);
        System.out.println("\n");
//        while(P[saveMaxIndex]!=-1){
////            System.out.print("Cube number "+saveMaxIndex+":\t\t");
//            cube[saveMaxIndex].printOneCube();
//            System.out.println();
//            saveMaxIndex=P[saveMaxIndex];
//        }
    }

    public static void printCubesArray(Cube[] cubes,int numOfCubes){
        System.out.print("\t\t\t");
        for(int i=0;i<numOfCubes;i++)
            System.out.print(i+"\t\t");
        System.out.println();
        System.out.print("Length:\t\t");
        for(int i=0;i<numOfCubes;i++)
            System.out.print(cubes[i].getLength()+"\t\t");
        System.out.println();
        System.out.print("Width:\t\t");
        for(int i=0;i<numOfCubes;i++)
            System.out.print(cubes[i].getWidth()+"\t\t");
        System.out.println();
        System.out.print("Height:\t\t");
        for(int i=0;i<numOfCubes;i++)
            System.out.print(cubes[i].getHeight()+"\t\t");

    }
}
