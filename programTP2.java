import java.util.Scanner;
import java.math.BigInteger;


public class programTP2 {
    static boolean promptRetry(Scanner scan) {
        boolean result = false;
        boolean isValid = false;
        do {
            //Tanya user untuk mengulangi perhitungan
            String exit_prog;
            System.out.print("\n Anda ingin mengulang [y/t] : ");
            exit_prog = scan.nextLine();

            if (exit_prog.equals("Y") || exit_prog.equals("y")) {
                result = true;
                isValid = true;
            }

            if (exit_prog.equals("T") || exit_prog.equals("t")) {
                result = false;
                isValid = true;
            }
        } while(!isValid);
        return result;
    }

    static int scanInt(Scanner scan, int min, int max) {
        String in;
        int result = 0;
        boolean isValid = false;

        do {
            in = scan.nextLine();

            isValid = true;

            try {
                result = Integer.parseInt(in);
            }
            catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Harus berupa angka. (Ctrl+C untuk keluar)");
                isValid = false;
            }

            if (isValid && (result < min || result > max)) {
                System.out.printf("Input tidak valid! Minimal %d , maksimal %d. (Ctrl+C untuk keluar)\n", min, max);
                isValid = false;
            }

            if (!isValid) {
                System.out.print("Coba lagi: ");
            }

        } while (!isValid);

        return result;
    }

    static void Aritmatika(int a, int d, int n)
        {
            int curr_term;
            curr_term=a;
            for (int i = 1; i <= n; i++)
            { System.out.print(curr_term + " ");
                curr_term =curr_term + d;

            }
        }

    static void Geometri(int awal, int ratio, int input)
    {
        int curr_termG;
        for (int i = 0; i < input; i++) {
            curr_termG = awal * (int)Math.pow(ratio, i);
            System.out.print(curr_termG + " ");
        }
    }

    static BigInteger faktorial(int N)
    {
        // Initialize result
        BigInteger f
                = new BigInteger("1");
        // Multiply f with 2, 3, ...N
        for (int i = 2; i <= N; i++)
            f = f.multiply(BigInteger.valueOf(i));


        return f;
    }

    static void rumus_faktorial(int Z)
    {
        // Multiply f with 2, 3, ...N
        for (int i = Z-1 ; i >= 1 ; i--) {
            System.out.print(" " + "*" + " " + i  );
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean shouldRetry = false;

        System.out.println("\n          Belajar Deret Aritmatika, Geometri dan menghitung Faktorial");
//        var num for store variable input

        do {
            System.out.print("\n Masukkan banyak angka yang mau dicetak [2..10] : ");
            int num = scanInt(scan, 2, 10);
            System.out.print("\n Masukkan beda masing-masing angka [2..9]       : ");
            int num2 = scanInt(scan, 2, 9);

            // Deret aritmatika
            int a = 1;
            int d = num2;
            int n = num;
            System.out.print("\nDeret Aritmatika   : \n");
            Aritmatika(a, d, n);

            // Deret Geometri
            int awal = 1;
            int ratio = num2;
            int input = num;
            System.out.print("\nDeret Geometri     : \n");
            Geometri(awal, ratio, input);

            // Faktorial
            System.out.print("\nFaktorial dari " + num + "   :\n" + num);
            rumus_faktorial(num);
            System.out.print(" =  ");
            System.out.println(faktorial(num));

            shouldRetry = promptRetry(scan);

        } while (shouldRetry);
    }
}
