


    static int task1(int n) {
        if (n == 1) return 1;
        return n * n + task1(n - 1);
    }

    static int task2(int[] arr, int n) {
        if (n == 0) return 0;
        return arr[n - 1] + task2(arr, n - 1);
    }

    static int task3(int n) {
        if (n == 1) return 1;
        return n + task3(n - 1);
    }

    static int powerTask4(int b, int n) {
        if (n == 0) return 1;
        return b * powerTask4(b, n - 1);
    }

    static int task4(int b, int n) {
        if (n == 0) return 1;
        return powerTask4(b, n) + task4(b, n - 1);
    }

    static void task5(int n, Scanner sc) {
        if (n == 0) return;
        int x = sc.nextInt();
        task5(n - 1, sc);
        System.out.print(x + " ");
    }

    static void task6(int n, Scanner sc) {
        if (n == 0) return;
        String s = sc.next();
        task6(n - 1, sc);
        System.out.println(s);
    }

    static void fillSpiral(int[][] a, int top, int bottom, int left, int right, int[] num) {
        if (top > bottom || left > right) return;

        for (int i = left; i <= right; i++) a[top][i] = num[0]++;
        for (int i = top + 1; i <= bottom; i++) a[i][right] = num[0]++;
        if (top < bottom) {
            for (int i = right - 1; i >= left; i--) a[bottom][i] = num[0]++;
        }
        if (left < right) {
            for (int i = bottom - 1; i > top; i--) a[i][left] = num[0]++;
        }

        fillSpiral(a, top + 1, bottom - 1, left + 1, right - 1, num);
    }

    static void task7(int n) {
        int[][] a = new int[100][100];
        int[] num = {1};
        fillSpiral(a, 0, n - 1, 0, n - 1, num);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void generateTask8(int n, int k, int[] arr, int index) {
        if (index == n) {
            for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= k; i++) {
            arr[index] = i;
            generateTask8(n, k, arr, index + 1);
        }
    }

    static void task8(int n, int k) {
        int[] arr = new int[100];
        generateTask8(n, k, arr, 0);
    }

    static void task9(String str, int l, int r) {
        if (l == r) {
            System.out.println(str);
            return;
        }

        char[] arr = str.toCharArray();
        for (int i = l; i <= r; i++) {
            char temp = arr[l];
            arr[l] = arr[i];
            arr[i] = temp;

            task9(new String(arr), l + 1, r);

            temp = arr[l];
            arr[l] = arr[i];
            arr[i] = temp;
        }
    }

    static boolean task10(int n) {
        if (n == 1) return true;
        if (n <= 0 || n % 2 != 0) return false;
        return task10(n / 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(task1(4));

        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println(task2(arr2, 5));

        System.out.println(task3(5));

        System.out.println(task4(4, 3));

        task5(3, sc);
        System.out.println();

        task6(3, sc);

        task7(4);

        task8(2, 3);

        task9("IOX", 0, 2);

        for (int i = 0; i <= 32; i++) {
            if (task10(i))
                System.out.println(i + " is a power of two");
            else
                System.out.println(i + " is not a power of two");
        }
    }
}