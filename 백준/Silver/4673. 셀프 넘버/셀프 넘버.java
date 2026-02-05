
public class Main {
    public static void main(String[] args) {
        int[] dn = new int[10001];
        int num=1;
        // dn값 구하기
        // arr[val] = num(creator)
        // val > 10000 라면 검사를 안해도 된다
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
                sum += (target/n); // 
                target = target%n; // 1002 % 1000
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
