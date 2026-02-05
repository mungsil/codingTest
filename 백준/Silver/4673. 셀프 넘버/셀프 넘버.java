public class Main {
    public static void main(String[] args) {
        int[] dn = new int[10001];
        int num=1;

        while(true){
            int target = num;
            int sum=target;
            if(num > 10000){
                break;
            }
            while(true){
                int n=0;
                if(target > 9999){
                    n=10000;
                }
                else if(target > 999){
                    n=1000;                   
                }
                else if(target > 99){
                    n=100;                  
                }
                else if(target > 9){
                    n=10;                
                }
                else if(target > 0){
                    n=1;                   
                }
                sum += (target/n);  
                target = target%n;
                if(target == 0){
                    break;
                }
            }
            if(sum <= 10000){
                dn[sum] = num; 
            }
            num++;         
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i< 10001; i++){
            if(dn[i] == 0){
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }
}
