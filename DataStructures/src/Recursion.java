
public class Recursion {
	public static void main(String[] args) {
//		int[] data = {1,2,3,4,5,6,7,12,23,25,45,67,98,115,325,550,668,999};
//		System.out.println(iterativeBinarySearch(data, 999));
//		System.out.println(factorial(6));
//		System.out.println(linearSum(data,13));
//		display(data);
//		iterativeReverseArray(data);
//		display(data);
//		double start = System.nanoTime();
//		betterPower(2, 10000);
//		double end = System.nanoTime();
//		System.out.println(end-start);
//		start = System.nanoTime();
//		iterativeBetterPower(2, 10000);
//		end = System.nanoTime();
//		System.out.println(end-start);
//		double start = System.nanoTime();
//		iterativeBetterPower(2, 10000);
//		double end = System.nanoTime();
//		System.out.println(end-start);
//		start = System.nanoTime();
//		betterPower(2, 10000);
//		end = System.nanoTime();
//		System.out.println(end-start);
//		int[] array = {1,2,3};
//		display(array);
//		reverseArray(array, 0, array.length-1);
//		display(array);
	}
	//Recursive factorial:
	public static int factorial(int n) {
		if (n == 0) return 1;
		return n * factorial(n-1);
	}
	//Iterative factorial:
	public static int iterativeFactorial(int n) {
		int result = 1;
		for(int i = 1;i <= n;i++) {
			result *= i;
		} 
		return result;
	}
	//Recursive binarySearch:
	public static boolean binarySearch(int[] data, int target, int low, int high) {
		if (low > high) return false;
		else {
			int mid = (high+low)/2;
			if(data[mid] == target) return true;
			else if (data[mid] > target) return binarySearch(data, target, low, mid-1);
			return binarySearch(data, target, mid+1, high);
		}
	}
	//Iterative binarySearch:
	public static boolean iterativeBinarySearch(int[] data, int target) {
		int low = 0,high = data.length-1;
		while (low <= high) {
			int mid = (low+high)/2;
			if (data[mid] == target) return true;
			else if (data[mid] > target) high = mid-1;
			else low = mid+1;
		}
		return false;
	}
	//Recursive linearSum:
	public static double linearSum(int[] arr, int count) {
		if (count == 0) return 0;
		return arr[count-1] + linearSum(arr, count-1);
	}
	//Iterative linearSum:
	public static double iterativeLinearSum(int[] arr, int count) {
		int sum = 0;
		for(int i = 0;i < count;i++) {
			sum += arr[i];
		}
		return sum;
	}
	//Recursive reverseArray:
	public static int[] reverseArray(int[] arr, int low, int high) {
		if (low >= high) return arr;
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
		return reverseArray(arr, low+1, high-1);
	}
	//Iterative reverseArray:
	public static int[] iterativeReverseArray(int[] arr) {
		for (int i = 0;i < arr.length/2;i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		return arr;
	}
	//recursive power:
	public static double power(double base, int n) {
		if (base == 0) return 0;
		if (n == 0) return 1;
		return base * power(base, n-1);
	}
	//Iterative power:
	public static double iterativePower(double base, int n) {
		if (base == 0) return 0;
		int result = 1;
		for (int i = 0;i < n;i++) {
			result *= base;
		}
		return result;
	}
	//Recursive betterPower:
	public static double betterPower(double base, int n) {
		if (base == 0) return 0;
		if (n == 0) return 1;
		if (n%2 == 0) {
			double result = betterPower(base, n/2);
			return result * result;
		} else {
			double result = betterPower(base, (n-1)/2);
			return base * result * result;
		}
	}
	//Iterative betterPower:
	public static double iterativeBetterPower(double base, int n) {
		if (base == 0) return 0;
		if (n == 0) return 1;
		double result = 1;
		for (int i = 0;i < n/2;i++) {
			result *= base;
		}
		if (n%2 == 1) return base * result * result;
		return result * result;
	}
	//Recursive fibonacci:
	public static int fibonacci(int n) {
		if (n < 2) return n;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	//Iterative fibonacci:
	public static int iterativeFibonacci(int n) {
		if (n < 2) return n;
		int first = 1, second = 1, result = 1;
		for (int i = 0;i < n-2;i++) {
			result = first + second;
			first = second;
			second = result;
		}
		return result;
	}
	
	
	
	//Assisting Methods:
	public static void display(int[] arr) {
		if (arr.length == 0) return;
		StringBuilder sb = new StringBuilder("");
		for (int i = 0;i < arr.length;i++) {
			sb.append(arr[i] + ", ");
		}
		sb.deleteCharAt(sb.length()-1);sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
}
