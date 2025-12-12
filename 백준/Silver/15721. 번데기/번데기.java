import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();  // 사람 수
        int T = sc.nextInt();  // T번째 등장하는 구호
        int target = sc.nextInt(); // 0=뻔, 1=데기
        
        int targetSoundCount = 0;
        int person = 0;
        int n = 1;
        
        int bbun = 0;
        int deggy = 1;

        int[] startPackage = {bbun,deggy,bbun,deggy};
        while(true){
        for(int sound: startPackage){
            if(sound == target){
                targetSoundCount++;
            }
            if(targetSoundCount == T){
                System.out.print(person);
                return;
            }
            person = (person+1)%A;
        }
        
        // n-1X뻔
        for(int i=0; i<n+1;i++){
            if(bbun == target){
                targetSoundCount++;
            }
            if(targetSoundCount == T){
                System.out.print(person);
                return;
            }
            person = (person+1)%A;
        }
        
        for(int i=0; i<n+1; i++){
            if(deggy == target){
                targetSoundCount++;
            }
            if(targetSoundCount == T){
                System.out.print(person);
                return;
            }
            person = (person+1)%A;
        }
            n++;
        }
    }
}