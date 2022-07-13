package joel.poker.launch;

public class Test {

    private Test() {
        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                for (int c = 0; c < 10; c++) {
                    if (test(a,b,c)) System.out.println(100*a+10*b+c);
                }
            }
        }
    }

    private boolean test(int a, int b, int c) {
        return test1(a,b,c) && test2(a,b,c) && test3(a,b,c) && test4(a,b,c) && test5(a,b,c);
    }

    private boolean test1(int a, int b, int c) {
        int count = 0;
        if (a==2) count++;
        if (b==9) count++;
        if (c==1) count++;
        return count==1;
    }

    private boolean test2(int a, int b, int c) {
        int count = 0;
        if (subtest2(a)) count++;
        if (subtest2(b)) count++;
        if (subtest2(c)) count++;
        return count==1;
    }
    private boolean subtest2(int a) {
        return a==2 || a==4 || a==5;
    }

    private boolean test3(int a, int b, int c) {
        int count = 0;
        if (subtest3(a)) count++;
        if (subtest3(b)) count++;
        if (subtest3(c)) count++;
        return count==2;
    }
    private boolean subtest3(int a) {
        return a==4 || a==6 || a==3;
    }

    private boolean test4(int a, int b, int c) {
        int count = 0;
        if (a==5) count++;
        if (b==7) count++;
        if (c==8) count++;
        return count==0;
    }

    private boolean test5(int a, int b, int c) {
        int count = 0;
        if (subtest5(a)) count++;
        if (subtest5(b)) count++;
        if (subtest5(c)) count++;
        return count==1;
    }
    private boolean subtest5(int a) {
        return a==5 || a==6 || a==9;
    }

    public static void main(String[] args) {

        new Test();
//        Card[] cards = new Card[] {
//                Card.FOUR_DIAMONDS,
//                Card.EIGHT_CLUBS,
//                Card.TEN_CLUBS,
//                Card.ACE_DIAMONDS,
//                Card.TEN_HEARTS,
//                Card.TWO_SPADES,
//                Card.TWO_HEARTS
//        };
//
//        Hand hand = HandUtils.fromCards(cards);
//
//        System.out.println("\n" + hand.toString());


    }

}
