import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class text {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Date date;
        boolean flag = true;
        double consumption;//consumption用于存放消费金额
        double money;
        String LiYou;
        int pick;//控制选择
        double balance = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String details = "============明细==========";
        do {
            System.out.println("===============零钱通菜单==============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退     出");
            System.out.println("请选择1~4");
            pick = scanner.nextInt();
            switch (pick) {
                case 1:
                    System.out.println(details);
                    break;
                case 2:
                    System.out.println("请输入入账金额：");
                    money = scanner.nextDouble();
                    if (money > 0) {
                        date = new Date();
                        balance += money;
                        details += "\n收益入账\t" + money + "\t" + sdf.format(date) + "\t余额：" + balance;
                    } else {
                        System.out.println("你输入的数有误");
                    }
                    break;
                case 3:
                    System.out.println("请输入消费理由：");
                    LiYou = scanner.next();
                    System.out.println("请输入消费金额：");
                    consumption = scanner.nextDouble();
                    if (consumption > 0 && consumption <= balance) {
                        date = new Date();
                        balance -= consumption;//余额减去消费金额
                        details += "\n" + LiYou + "\t\t" + consumption + "\t" + sdf.format(date) + "\t余额：" + balance;
                    } else {
                        System.out.println("你输入的数有误");
                    }
                    break;
                case 4:
                    System.out.println("你确定要退出零钱通吗？Y/N");
                    String temp = scanner.next();
                    if (temp.equals("y")) {
                        flag = false;//退出把旗帜置为假
                    }
                    break;
                default:
                    System.out.println("你输入的数有误");
                    break;


            }
        } while (flag);
    }
}
